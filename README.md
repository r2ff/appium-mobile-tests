# appium-mobile-tests



Run test on browserstack:
```bash
gradle clean test -DdeviceHost=browserstack
```

Run test emulator:
```bash
gradle clean test -DdeviceHost=emulator
```

Run test local (default):
```bash
gradle clean test -DdeviceHost=local
```

Also, you should add configuration file to config/(browserstack/emulator/local).properties

Structure of browserstack.properties
```bash
browserstack.user=
browserstack.key=
browserstack.app=
browserstack.url=http://hub.browserstack.com/wd/hub
browserstack.device=Google Pixel 3 
browserstack.os.version=9.0
```

Structure of emulator.properties
```bash
local.app=src/test/resources/app-alpha-universal-release.apk
local.url=http://127.0.0.1:4723/wd/hub
local.device.name=Pixel_4_API_30
local.os.version=11.0
```


Structure of local.properties
```bash
local.app=src/test/resources/app-alpha-universal-release.apk
local.url=http://127.0.0.1:4723/wd/hub
local.device.name=885545
local.os.version=10.0
```





