#!/usr/bin/python3

#imports
from watchdog.observers import Observer
from watchdog.events import FileSystemEventHandler
from networktables import NetworkTables
from networktables.util import ntproperty
import threading
import os

#Create the barcodes file
f = open('/home/pi/barcodes.txt', 'w')
f.close()

#Create thread to make sure networktables is connected
cond = threading.Condition()
notified = [False]

#Create a listener 
def connectionListener(connected, info):
    with cond:
        notified[0] = True
        cond.notify()

#Instantiate NetworkTables
NetworkTables.initialize(server="10.12.34.2")
NetworkTables.addConnectionListener(connectionListener, immediateNotify=True)

#Wait until connected
with cond:
    if not notified[0]:
        cond.wait()

#Create the vision Table
ntBarcodeData = ntproperty('/Vision/barcodeData', "null")
ntBarcodeType = ntproperty('/Vision/barcodeType', "null")
ntReadBarcode = ntproperty('/Vision/readBarcode', False)

#Get Table
table = NetworkTables.getTable('Vision')

#Create the system handler
class MyHandler(FileSystemEventHandler):
    def on_modified(self, event):
        try:
            file = open('./barcodes.txt', 'r')
            table.putString('barcodeData', file.readline())
            table.putString('barcodeType', file.readline())
            file.close()
        except:
            pass #when file is not created yet
 
event_handler = MyHandler()
observer = Observer()
observer.schedule(event_handler, path='./barcodes.txt', recursive=False)
observer.start()

#The forever loop
while(True):
    if table.getBoolean('readBarcode', False) == True:
        table.putBoolean('readBarcode', False)
        os.system('python3 /home/pi/readBarcode.py')
    try:
        pass
    except KeyboardInterrupt:
        observer.stop()