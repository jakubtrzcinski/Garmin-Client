# Garmin Connect client
Simple java client inspired by
[Tapiriik](https://github.com/cpfair/tapiriik) and 
[Garminexport](https://github.com/petergardfjall/garminexport) 
that can fetch activities and heart rate from your garmin account. 

## Instalation

### Maven 
```xml
<dependencies>
    <dependency>
        <groupId>pl.jakubtrzcinski</groupId>
        <artifactId>garmin-client</artifactId>
        <version>1.0.5.RELEASE</version>
    </dependency>
</dependencies>
```

### Gradle
```groovy
dependencies {
    implementation 'pl.jakubtrzcinski:garmin-client:1.0.5.RELEASE'
}
```

## Authentication

### Login password authentication

```java
var client = GarminConnectClient.fromLoginPassword(
        "your.email@example.com", 
        "password"
);
```
### Cached token

```java
var token = new UserPasswordTokenSupplier(
        "your.email@example.com",
        "password"
).get();
var client = new GarminConnectClient(new HardcodedTokenSupplier(
        token.getSessionId(),
        token.getSsoGuid()
));
```

### OAuth2

TODO



## Features

### Activities

#### Fetch list of activities

```java
var activities = client.getActivities(10, 0);
```

#### Fetch tcx of given activityId

```java
var rawTcx = client.getRawTcx(2137);
var tcxPojo = client.getTcx(2137);
```

#### Fetch gpx of given activityId

```java
var rawGpx = client.getRawGpx(2137);
var gpxPojo = client.getGpx(2137);
```

#### Upload activities

```java
client.uploadTcx(new FileInputStream("sample.tcx"));
client.uploadGpx(new FileInputStream("sample.gpx"));
```

### Heart

#### Heart rate data for a single day

```java
var heart = client.getHeartRate(LocalDate.of(2020, 1, 3));
```

### Weight

TODO

### Sleep

TODO

## Exceptions

| Exception Class                        | Description                         |
|----------------------------------------|-------------------------------------|
| SessionExpiredGarminConnectException   | token is expired                    |
| ActivityNotFoundGarminConnectException | activity with given id is not found |
| RateLimitGarminConnectException        | you're sending tooo much requests   |
| UnknownGarminConnectException          | something wrong went                |

## Changelog
## 1.0.5 - 2021-01-09
- added gpx upload
- added tcx upload
- updated README
## 1.0.4 - 2021-01-03
- added ability to fetch heart rate from given date
- updated README
## 1.0.3 - 2020-12-27
- Added java docs
- updated README
## 1.0.2 - 2020-12-26
- Authentication refactor
- updated README
