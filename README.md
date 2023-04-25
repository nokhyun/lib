# Android Util Library

minTarget: 24
version: 0.0.0-alpha
implementation("com.github.nokhyun:lib:$version")

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
