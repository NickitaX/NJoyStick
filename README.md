# NJoyStick

NJoyStick is a simple library which allows you to add JoyStick view for android.

![Alt text](./demo.gif?raw=true "Demo")

Basic features:

 * Movement XY
 * Custom listener for events
 * Reset of pad to centre on touch up

 Installation:
 * Download njoystick-release.aar and drop it to your libs folder
 * In app build.graddle include lib source:
 ```java
 allprojects {
   repositories {
      jcenter()
      flatDir {
        dirs 'libs'
      }
   }
}
});
```
* Add compile path to your build.graddle:
 ```java
compile(name:'cards', ext:'aar')
```
 * Done!

 Usage:
 * Add NJoyStick to XML file of your layout:
 ```XML
 <nickita.gq.njoystick.NJoyStick
      android:id="@+id/joystick"
      android:layout_width="200dp"
      android:layout_height="200dp" />
 ```
* Initialise NJoyStick:
 ```java
NJoyStick j = (NJoyStick) findViewById(R.id.joystick);
 ```
 * Add listener for movement event
 ```java
 j.setJOnMoveListener(new JButtonListener() {
             @Override
             public void JoystickChanged(JEvent event) {
                 System.out.println("MOVED: x"+event.getJx()+", y:"+event.getJy());
             }
         });
 ```

ToDo:

 * Put project to jcenter
