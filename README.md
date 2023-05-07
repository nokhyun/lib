# Android Util Library

minTarget: 24
version: 1.0.0
```
implementation("com.github.nokhyun:lib:$version")
```
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```

##
- Compose Text setting dp and customFontFamily
```
 TextDp(                                
     "HelloWorld",                      
     fontSet = FontSet(                 
         fontSize = 28.textDp,          
         fontFamily = FontFamily.Default
     ),                                 
     fontWeight = FontWeight.Medium,    
 ) 
 ````
