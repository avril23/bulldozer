# Bulldozer #

## a REST API test framework ##

### Syntax ###
#### Params(Optional) ####
```
Params := (
    "key1" := "string value",
    "key2" := 123
)
```
max count of "Params" keys is 22

#### Headers(Optional) ####
```
Headers := (
    "Content-Type" := "application/json",
    "UserId" := 100
)
```
max count of "Headers" keys is 22

#### Request ####
```
GET >> "/ss/wsevent"
```

#### Assert ####
```
(Assert code) === 200
(Assert body) === "OK"
(Assert body).asJson("code") === "0"
(Assert body).asJson.size === 5
```
