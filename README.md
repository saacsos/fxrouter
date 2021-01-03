# FXRouter

> ปรับปรุงจาก https://github.com/Marcotrombino/FXRouter

A simple JavaFX router to switch between application scenes

## วิธีกำหนดใน maven

1. ดาวน์โหลด .jar จาก https://github.com/saacsos/fxrouter/releases/latest
2. วาง .jar ไปไว้ที่ resources ของ maven project
3. กำหนด dependency ใน pom.xml
```
<dependency>
    <groupId>com.github.saacsos</groupId>
    <artifactId>FXRouter</artifactId>
    <version>1.0.0</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/src/main/resources/FXRouter.jar</systemPath>
</dependency>
```

## วิธีการใช้งาน
ดูเพิ่มเติมได้ที่ https://github.com/Marcotrombino/FXRouter

### 1. Bind

Add FXRouter as project dependency and import it from its package:

```java
import com.github.saacsos.FXRouter;
```

Connect FXRouter to your application stage: call bind() from your main class start() method (if you use IntelliJ IDEA) or similar:

```java
FXRouter.bind(this, primaryStage);
```

**You can optionally set application title and size (width, height):**
```java
FXRouter.bind(this, primaryStage, "MyApplication", 800, 600);
```

### 2. Set routes

Define your Application routes with a **label identifier** and its corresponding .fxml screen file:

```java
FXRouter.when("login", "myloginscreen.fxml");
FXRouter.when("profile", "myprofilescreen.fxml");
// ... others
```

**You can optionally specify the route title and size (width, height):**
```java
FXRouter.when("login", "myloginscreen.fxml", "My login screen", 1000, 500);
```

### 3. Switch view
Switch routes from anywhere (controllers, services, etc):
```java
try {
    FXRouter.goTo("login");  // switch to myloginscreen.fxml
} catch (IOException e) {
    e.printStackTrace();
} 
```

#### Passing and retrieving data between routes
Your application could need to pass some data to another route and then retrieve those data:

##### Send data from the current scene

`goTo()` accepts two parameters: a **route identifier** and an **Object**:

**(Multiples data could be stored on an appropriate Collection)**

```java
try{
    FXRouter.goTo("profile","johndoe22");     // switch to myprofilescreen.fxml passing an username
} catch (IOException e) {
    e.printStackTrace();    
}
```

##### Get data from the destination scene
`getData()` returns an **Object** which can be cast to appropriate data type:

```java
String username = (String) FXRouter.getData();     // retrieve johndoe22
```

## Example

### Without FXRouter

A common JavaFX project starter:

```java
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
```

### Using FXRouter

```java
package sample;

import com.github.saacsos.FXRouter;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXRouter.bind(this, primaryStage, "Hello World");
        configRoute();
        FXRouter.goTo("first");
    }

    private static void configRoute() {
        FXRouter.when("first", "first.fxml");
        FXRouter.when("second", "second.fxml");
        FXRouter.when("third", "third.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```