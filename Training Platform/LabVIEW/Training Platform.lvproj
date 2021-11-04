<?xml version='1.0' encoding='UTF-8'?>
<Project Type="Project" LVVersion="20008000">
	<Item Name="My Computer" Type="My Computer">
		<Property Name="server.app.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="server.control.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="server.tcp.enabled" Type="Bool">false</Property>
		<Property Name="server.tcp.port" Type="Int">0</Property>
		<Property Name="server.tcp.serviceName" Type="Str">My Computer/VI Server</Property>
		<Property Name="server.tcp.serviceName.default" Type="Str">My Computer/VI Server</Property>
		<Property Name="server.vi.callsEnabled" Type="Bool">true</Property>
		<Property Name="server.vi.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="specify.custom.address" Type="Bool">false</Property>
		<Item Name="Dependencies" Type="Dependencies"/>
		<Item Name="Build Specifications" Type="Build"/>
	</Item>
	<Item Name="Raspberry Pi 2 B" Type="Raspberry Pi 2 B">
		<Property Name="alias.name" Type="Str">Raspberry Pi 2 B</Property>
		<Property Name="alias.value" Type="Str">172.16.0.1</Property>
		<Property Name="CCSymbols" Type="Str">TARGET_TYPE,RT;OS,Linux;CPU,ARM;LINX_DEVICE,True;LINX_DEVICE_FAMILY,4;LINX_DEVICE_ID,3;</Property>
		<Property Name="host.ResponsivenessCheckEnabled" Type="Bool">true</Property>
		<Property Name="host.ResponsivenessCheckPingDelay" Type="UInt">5000</Property>
		<Property Name="host.ResponsivenessCheckPingTimeout" Type="UInt">1000</Property>
		<Property Name="host.TargetCPUID" Type="UInt">8</Property>
		<Property Name="host.TargetOSID" Type="UInt">8</Property>
		<Property Name="target.cleanupVisa" Type="Bool">false</Property>
		<Property Name="target.FPProtocolGlobals_ControlTimeLimit" Type="Int">300</Property>
		<Property Name="target.getDefault-&gt;WebServer.Port" Type="Int">80</Property>
		<Property Name="target.getDefault-&gt;WebServer.Timeout" Type="Int">60</Property>
		<Property Name="target.IOScan.Faults" Type="Str"></Property>
		<Property Name="target.IOScan.NetVarPeriod" Type="UInt">100</Property>
		<Property Name="target.IOScan.NetWatchdogEnabled" Type="Bool">false</Property>
		<Property Name="target.IOScan.Period" Type="UInt">10000</Property>
		<Property Name="target.IOScan.PowerupMode" Type="UInt">0</Property>
		<Property Name="target.IOScan.Priority" Type="UInt">0</Property>
		<Property Name="target.IOScan.ReportModeConflict" Type="Bool">true</Property>
		<Property Name="target.IsRemotePanelSupported" Type="Bool">true</Property>
		<Property Name="target.RTCPULoadMonitoringEnabled" Type="Bool">true</Property>
		<Property Name="target.RTDebugWebServerHTTPPort" Type="Int">8001</Property>
		<Property Name="target.RTTarget.ApplicationPath" Type="Path">/c/ni-rt/startup/startup.rtexe</Property>
		<Property Name="target.RTTarget.EnableFileSharing" Type="Bool">true</Property>
		<Property Name="target.RTTarget.IPAccess" Type="Str">+*</Property>
		<Property Name="target.RTTarget.LaunchAppAtBoot" Type="Bool">false</Property>
		<Property Name="target.RTTarget.VIPath" Type="Path">/home/lvuser/natinst/bin</Property>
		<Property Name="target.server.app.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="target.server.control.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="target.server.tcp.access" Type="Str">+*</Property>
		<Property Name="target.server.tcp.enabled" Type="Bool">false</Property>
		<Property Name="target.server.tcp.paranoid" Type="Bool">true</Property>
		<Property Name="target.server.tcp.port" Type="Int">3363</Property>
		<Property Name="target.server.tcp.serviceName" Type="Str">Main Application Instance/VI Server</Property>
		<Property Name="target.server.tcp.serviceName.default" Type="Str">Main Application Instance/VI Server</Property>
		<Property Name="target.server.vi.access" Type="Str">+*</Property>
		<Property Name="target.server.vi.callsEnabled" Type="Bool">true</Property>
		<Property Name="target.server.vi.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="target.WebServer.Config" Type="Str">Listen 8000

NI.ServerName default
DocumentRoot "$LVSERVER_DOCROOT"
TypesConfig "$LVSERVER_CONFIGROOT/mime.types"
DirectoryIndex index.htm
WorkerLimit 10
InactivityTimeout 60

LoadModulePath "$LVSERVER_MODULEPATHS"
LoadModule LVAuth lvauthmodule
LoadModule LVRFP lvrfpmodule

#
# Pipeline Definition
#

SetConnector netConnector

AddHandler LVAuth
AddHandler LVRFP

AddHandler fileHandler ""

AddOutputFilter chunkFilter


</Property>
		<Property Name="target.WebServer.Enabled" Type="Bool">false</Property>
		<Property Name="target.WebServer.LogEnabled" Type="Bool">false</Property>
		<Property Name="target.WebServer.LogPath" Type="Path">/c/ni-rt/system/www/www.log</Property>
		<Property Name="target.WebServer.Port" Type="Int">80</Property>
		<Property Name="target.WebServer.RootPath" Type="Path">/c/ni-rt/system/www</Property>
		<Property Name="target.WebServer.TcpAccess" Type="Str">c+*</Property>
		<Property Name="target.WebServer.Timeout" Type="Int">60</Property>
		<Property Name="target.WebServer.ViAccess" Type="Str">+*</Property>
		<Property Name="target.webservices.SecurityAPIKey" Type="Str">PqVr/ifkAQh+lVrdPIykXlFvg12GhhQFR8H9cUhphgg=:pTe9HRlQuMfJxAG6QCGq7UvoUpJzAzWGKy5SbZ+roSU=</Property>
		<Property Name="target.webservices.ValidTimestampWindow" Type="Int">15</Property>
		<Item Name="Main.vi" Type="VI" URL="../Main.vi"/>
		<Item Name="Dependencies" Type="Dependencies">
			<Item Name="vi.lib" Type="Folder">
				<Item Name="Acquire Semaphore.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/semaphor.llb/Acquire Semaphore.vi"/>
				<Item Name="AddNamedSemaphorePrefix.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/semaphor.llb/AddNamedSemaphorePrefix.vi"/>
				<Item Name="BuildHelpPath.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/BuildHelpPath.vi"/>
				<Item Name="button_sem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/button_sem.vi"/>
				<Item Name="Check Special Tags.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Check Special Tags.vi"/>
				<Item Name="Clear Errors.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Clear Errors.vi"/>
				<Item Name="Convert property node font to graphics font.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Convert property node font to graphics font.vi"/>
				<Item Name="createBool.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/createBool.vi"/>
				<Item Name="createData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/polymorphic/createData.vi"/>
				<Item Name="createDataBase.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/createDataBase.vi"/>
				<Item Name="createDouble.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/createDouble.vi"/>
				<Item Name="createFloat.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/createFloat.vi"/>
				<Item Name="createInt8_t.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/createInt8_t.vi"/>
				<Item Name="createInt16_t.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/createInt16_t.vi"/>
				<Item Name="createInt32_t.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/createInt32_t.vi"/>
				<Item Name="createSem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Sem/createSem.vi"/>
				<Item Name="createUint8_t.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/createUint8_t.vi"/>
				<Item Name="createUint16_t.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/createUint16_t.vi"/>
				<Item Name="createUint32_t.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/createUint32_t.vi"/>
				<Item Name="Details Display Dialog.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Details Display Dialog.vi"/>
				<Item Name="DialogType.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/DialogType.ctl"/>
				<Item Name="DialogTypeEnum.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/DialogTypeEnum.ctl"/>
				<Item Name="Error Cluster From Error Code.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Error Cluster From Error Code.vi"/>
				<Item Name="Error Code Database.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Error Code Database.vi"/>
				<Item Name="ErrWarn.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/ErrWarn.ctl"/>
				<Item Name="eventvkey.ctl" Type="VI" URL="/&lt;vilib&gt;/event_ctls.llb/eventvkey.ctl"/>
				<Item Name="Find Tag.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Find Tag.vi"/>
				<Item Name="Format Message String.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Format Message String.vi"/>
				<Item Name="General Error Handler Core CORE.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/General Error Handler Core CORE.vi"/>
				<Item Name="General Error Handler.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/General Error Handler.vi"/>
				<Item Name="Get String Text Bounds.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Get String Text Bounds.vi"/>
				<Item Name="Get Text Rect.vi" Type="VI" URL="/&lt;vilib&gt;/picture/picture.llb/Get Text Rect.vi"/>
				<Item Name="GetHelpDir.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/GetHelpDir.vi"/>
				<Item Name="GetNamedSemaphorePrefix.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/semaphor.llb/GetNamedSemaphorePrefix.vi"/>
				<Item Name="GetRTHostConnectedProp.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/GetRTHostConnectedProp.vi"/>
				<Item Name="Global Variable.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/Global Variable.vi"/>
				<Item Name="gyro_sem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/gyro_sem.vi"/>
				<Item Name="init_interface.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/init_interface.vi"/>
				<Item Name="Initialize VMX.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/SubVIs/Initialize VMX.vi"/>
				<Item Name="ir_sem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/ir_sem.vi"/>
				<Item Name="limit_sem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/limit_sem.vi"/>
				<Item Name="Longest Line Length in Pixels.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Longest Line Length in Pixels.vi"/>
				<Item Name="LVBoundsTypeDef.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/miscctls.llb/LVBoundsTypeDef.ctl"/>
				<Item Name="LVRectTypeDef.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/miscctls.llb/LVRectTypeDef.ctl"/>
				<Item Name="motor_sem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/motor_sem.vi"/>
				<Item Name="motorDIR_sem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/motorDIR_sem.vi"/>
				<Item Name="motorRPM_sem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/motorRPM_sem.vi"/>
				<Item Name="Not A Semaphore.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/semaphor.llb/Not A Semaphore.vi"/>
				<Item Name="Not Found Dialog.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Not Found Dialog.vi"/>
				<Item Name="Obtain Semaphore Reference.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/semaphor.llb/Obtain Semaphore Reference.vi"/>
				<Item Name="ping_sem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/ping_sem.vi"/>
				<Item Name="postSem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Sem/postSem.vi"/>
				<Item Name="pulse_sem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/pulse_sem.vi"/>
				<Item Name="qti_sem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/qti_sem.vi"/>
				<Item Name="Read_Handle.ctl" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Ctl/Read_Handle.ctl"/>
				<Item Name="Read_Memory.ctl" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Ctl/Read_Memory.ctl"/>
				<Item Name="readBoolData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/readBoolData.vi"/>
				<Item Name="readData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/polymorphic/readData.vi"/>
				<Item Name="readDouble.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/readDouble.vi"/>
				<Item Name="readFloatData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/readFloatData.vi"/>
				<Item Name="readInt8_tData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/readInt8_tData.vi"/>
				<Item Name="readInt16_tData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/readInt16_tData.vi"/>
				<Item Name="readInt32_tData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/readInt32_tData.vi"/>
				<Item Name="readUint8_tData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/readUint8_tData.vi"/>
				<Item Name="readUint16_tData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/readUint16_tData.vi"/>
				<Item Name="readUint32_tData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/readUint32_tData.vi"/>
				<Item Name="Release Semaphore.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/semaphor.llb/Release Semaphore.vi"/>
				<Item Name="Reset.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/SubVIs/Reset.vi"/>
				<Item Name="resetGyro_sem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/resetGyro_sem.vi"/>
				<Item Name="resetTitanENC_sem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/resetTitanENC_sem.vi"/>
				<Item Name="resetVmxENC.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/resetVmxENC.vi"/>
				<Item Name="Search and Replace Pattern.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Search and Replace Pattern.vi"/>
				<Item Name="Semaphore RefNum" Type="VI" URL="/&lt;vilib&gt;/Utility/semaphor.llb/Semaphore RefNum"/>
				<Item Name="Semaphore Refnum Core.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/semaphor.llb/Semaphore Refnum Core.ctl"/>
				<Item Name="servo_sem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/servo_sem.vi"/>
				<Item Name="Set Bold Text.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Set Bold Text.vi"/>
				<Item Name="Set String Value.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Set String Value.vi"/>
				<Item Name="Simple Error Handler.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Simple Error Handler.vi"/>
				<Item Name="stopbutton_sem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/stopbutton_sem.vi"/>
				<Item Name="TagReturnType.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/TagReturnType.ctl"/>
				<Item Name="Three Button Dialog CORE.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Three Button Dialog CORE.vi"/>
				<Item Name="Three Button Dialog.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Three Button Dialog.vi"/>
				<Item Name="titanENC_sem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/titanENC_sem.vi"/>
				<Item Name="Trim Whitespace.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Trim Whitespace.vi"/>
				<Item Name="Update VMX Data.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/SubVIs/Update VMX Data.vi"/>
				<Item Name="Validate Semaphore Size.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/semaphor.llb/Validate Semaphore Size.vi"/>
				<Item Name="VMX Library.lvlib" Type="Library" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/Library/VMX Library.lvlib"/>
				<Item Name="VMX Read FGV.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/SubVIs/VMX Read FGV.vi"/>
				<Item Name="VMX Read.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/SubVIs/VMX Read.vi"/>
				<Item Name="VMX Write FGV.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/SubVIs/VMX Write FGV.vi"/>
				<Item Name="VMX Write.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/SubVIs/VMX Write.vi"/>
				<Item Name="vmxENC_sem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/init/VIs/vmxENC_sem.vi"/>
				<Item Name="waitSem.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Sem/waitSem.vi"/>
				<Item Name="whitespace.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/whitespace.ctl"/>
				<Item Name="Write_Handle.ctl" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Ctl/Write_Handle.ctl"/>
				<Item Name="Write_Memory.ctl" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Ctl/Write_Memory.ctl"/>
				<Item Name="writeBoolData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/writeBoolData.vi"/>
				<Item Name="writeData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/polymorphic/writeData.vi"/>
				<Item Name="writeDoubleData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/writeDoubleData.vi"/>
				<Item Name="writeFloatData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/writeFloatData.vi"/>
				<Item Name="writeInt8_tData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/writeInt8_tData.vi"/>
				<Item Name="writeInt16_tData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/writeInt16_tData.vi"/>
				<Item Name="writeInt32_tData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/writeInt32_tData.vi"/>
				<Item Name="writeUint8_tData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/writeUint8_tData.vi"/>
				<Item Name="writeUint16_tData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/writeUint16_tData.vi"/>
				<Item Name="writeUint32_tData.vi" Type="VI" URL="/&lt;vilib&gt;/High Genius/HG_WSI_Tookit/Dependencies/sub/utility/Data/writeUint32_tData.vi"/>
			</Item>
			<Item Name="HG_LabVIEW_VMXPi.dll" Type="Document" URL="HG_LabVIEW_VMXPi.dll">
				<Property Name="NI.PreserveRelativePath" Type="Bool">true</Property>
			</Item>
			<Item Name="libhglabview.dll" Type="Document" URL="libhglabview.dll">
				<Property Name="NI.PreserveRelativePath" Type="Bool">true</Property>
			</Item>
		</Item>
		<Item Name="Build Specifications" Type="Build"/>
	</Item>
</Project>
