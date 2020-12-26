# Garmin Connect client
Simple java client that can fetch activities from your garmin account.
## Instalation

### Maven 
```xml
<dependencies>
    <dependency>
        <groupId>pl.jakubtrzcinski</groupId>
        <artifactId>garmin-client</artifactId>
        <version>1.0.1.RELEASE</version>
    </dependency>
</dependencies>
```

### Gradle
```groovy
dependencies {
    implementation 'pl.jakubtrzcinski:garmin-client:1.0.1.RELEASE'
}
```
## Features

### Activities list

```java
var client = GarminConnectClient.fromLoginPassword(
        "your.email@example.com", 
        "password"
);

var activities = client.getActivities(10, 0);
```

### Fetch tcx of given activityId

```java
var client = GarminConnectClient.fromLoginPassword(
        "your.email@example.com", 
        "password"
);

var rawTcx = client.getRawTcx(2137);
```

### Fetch gpx of given activityId

```java
var client = GarminConnectClient.fromLoginPassword(
        "your.email@example.com", 
        "password"
);

var rawGpx = client.getRawGpx(2137);
```
