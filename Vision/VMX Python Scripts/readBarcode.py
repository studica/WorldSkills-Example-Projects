#imports
import cv2 as cv
from pyzbar.pyzbar import decode

#initialize variables to prevent errors if no barcode found 
BarcodeData = 'No Barcode Found'
BarcodeType = 'null'

# Snap an image
cap = cv.VideoCapture(0)
cap.set(3, 640) # Width
cap.set(4, 480) # Height
ret, raw = cap.read()
raw = cv.flip(raw, -1)
cap.release()

# process image and output barcode data to file
for barcode in decode(raw):
    BarcodeData = barcode.data.decode("utf-8")
    BarcodeType = barcode.type
    #print("Found {} barcode: {}".format(barcode.type, barcode.data.decode("utf-8"))) # For debugging
    
file = open('./barcodes.txt', 'w')
file.write(BarcodeData)
file.write('\n')
file.write(BarcodeType)
file.close()



