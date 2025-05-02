## OpenBot

### Development
#### Build  
There are 2 build methods:  
- Normal build
- Fast Build (**For development**)

##### Normal Build
```shell
./gradlew build
```
This will generate a common OpenBot archive and it's the slowest.

##### Fast Build
```shell
./gradlew build -x test -x check --parallel --build-cache
```
This will generate a common OpenBot archive.  
**!** And it will **skip** some steps:
- [x] Code Checking
- [x] Test  
___You can also use *Shadow* to improve building speed___

