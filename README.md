# Bulldozer

## a test framework based on DSL for REST API

### Syntax
#### Params(Optional)
```scala
Params := (
    "key1" := "string value",
    "key2" := 123
)
```
max count of "Params" keys is 22

#### Headers(Optional)
```scala
Headers := (
    "Content-Type" := "application/json",
    "UserId" := 100
)
```
max count of "Headers" keys is 22

#### Request
```scala
GET >> "/your/rest/api"
```

#### Response
```json
{
    "keyA": "valueA",
    "keyB": "valueB",
    "keyC": {
        "keyC1": "valueC1",
        "keyC2": "valueC2"
    }
}
```

#### Assert
``` scala
Assert(code === 200)
Assert(body.decode("keyB") === "valueB")
Assert(body.decode("keyC").decode("keyC2") === "valueC2")
```
