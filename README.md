# Android Util Library

minTarget: 24

[![](https://jitpack.io/v/nokhyun/lib.svg)](https://jitpack.io/#nokhyun/lib)
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
 Text(                                
     "HelloWorld",                      
     fontSet = FontSet(                 
         fontSize = 28.textDp,          
         fontFamily = FontFamily.Default
     ),                                 
     fontWeight = FontWeight.Medium,    
 ) 
 ````
