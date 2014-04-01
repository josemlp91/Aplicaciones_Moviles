Monday, March 10 2014 11:19 AM


#  Gooogle Drive y Android.
![](http://blog.zarovich.org/wp-content/uploads/2012/04/google_drive.jpg)



@[](http://youtu.be/pBFQdxA-apI)

Como sabemos Google Drive es un servicio en la nube de los muchos que ofrece el mercado actualmente, pero la "nube" es una cosa muy dispersa y debemos saber ubicar Google Drive dentro de todo este mundo.

[Google Drive](http://es.wikipedia.org/wiki/Google_Drive)

Drive dentro de mundo de las infraestructuras virtuales, se cataloga como IaaS "Infrastructure as a service" y es un medio de entrega de alamacenamiento básico y capacidades de cómputo como servicios estandarizados en la red. 


![](http://upload.wikimedia.org/wikipedia/commons/3/3c/Cloud_computing_layers.png)
![](http://es.wikipedia.org/wiki/Computaci%C3%B3n_en_la_nube)

Si nos fijamos en los servicios que se montan sobre G Drive, tales como  Google Docs & Spreadsheets, se ubican en la capa de SaaS, "Software as a Service"

[SaaS Wikipedia](http://es.wikipedia.org/wiki/Software_como_servicio)

Google Drive, básicamente ofrece un espacio de almacenamiento accesible, al que podemos conectar  con nuestros clientes, y almacenar archivos de todo tipo.

Como este espacio de almacenamiento es accesible desde cualquier lugar, se permiten crear aplicaciones que permitan realizar trabajo colaborativo desde varios clientes simultaneamente.


##Utilizar Google Drive en nuestras Aplicaciones

Para poder aprovechar Google Drive en nuestras aplicaciones, Google nos proporciona las "APIs", y la ofrece para los siguientes lenguajes (Java, PHP, JavaScript, .NET, Python, Ruby, Go, Node.js) y en especial para Andriod y iOS.

La "api" para Android ha sido recientemente renovada, y se ha hecho mucho mas rápida y fluida.

![](http://www.elandroidelibre.com/wp-content/uploads/2014/01/Google-drive-nueva-api.png)

##Utilizar Google drive en Android.

He intentado realizar la configuración en los entornos AndroidStudio y Eclipse, y solo he conseguido completada en Eclipse, AndroidStudio no conseguía solucionar errores de dependencias.

El proceso seguido es el siguiente:



1. Instalar los Extras:

Desde Android SDK Manager instalar:

	Google Play services
    Google Repository

![](http://content.screencast.com/users/lopex-racing/folders/Jing/media/3ec53b05-c73a-410b-9563-39bf25117a08/2014-03-14_1613.png)


    
2. Instalar una API compatible
	Android 4.2.2 (API 17) 
    

3. Incluir la librería  **google-play-services_lib** en el proyecto.

![](http://content.screencast.com/users/lopex-racing/folders/Jing/media/83c240b6-91bc-4089-83f1-b123a56bb684/2014-03-14_1621.png)

####Configurar Gradle

Necesitamos especificar las dependencias, donde se especifica como se realiza el compilado, este archivo es el **build.gradle**. 

#####¿Que es gradle?

Gradle es una herramienta para automatizar la construcción de nuestros proyectos, por ejemplo las tareas de compilación, testing, empaquetado y el despliegue de los mismos.

Verifica si hubo algún cambio en el código fuente después de la última compilación, si es así re-compila todo, si no se ahorra la tarea. 

[http://wtanaka.com/node/8075](http://wtanaka.com/node/8075)

![](http://content.screencast.com/users/lopex-racing/folders/Jing/media/6115480c-7a00-4c2d-b18b-6a6dcb2a2b06/2014-03-14_2251.png)


#####Gradle

	defaultTasks 'all'
	task all {
	  doLast {
	    println 'Hello'
	  }
	}


#####Ant

	<?xml version="1.0" encoding="UTF-8"?>
	<project default="all">
	  <target name="all">
	    <echo message="Hello" />
	  </target>
	</project> 	 


#####Make

	all:
	    echo "Hello" 


#####Para Google Drive: 

Añadir:

        apply plugin: 'android'
    	...

        dependencies {
            compile 'com.android.support:appcompat-v7:+'
            compile 'com.google.android.gms:play-services:4.0.30'
        }

#### Configurar el App Manifest

Añadir en el App manifest un nuevo hijo a  <**application** >

	<meta-data android:name="com.google.android.gms.version"
           android:value="@integer/google_play_services_version" />


###Acticar Android ProGuard

Debemos activar, la función Android ProGuard, esta característica en la mayoría de los proyectos que realicemos es opcional, pero dado que en este tipo de proyectos necesitamos autentificamos con nuestro servicio en el Cloud, necesita almacenar las credenciales de forma segura, esta característica se convierte en obligatoria.



####¿Que es Android ProGuard?

Es una herramienta, que se encarga de optimizar, limpiar y obfuscar nuestro código.

Esto lo hace eliminado clases inútiles, renombrado clases y métodos con nombres sin significado semántico y ocultando las cadenas de caracteres.    

El resultado es un .apk más reducido, y con una dificultad superior para realizar ingeniería inversa. 

En las especificaciones de esta herramienta, se dice que es opcional, pero altamente recomendable.


Solo se ejecuta  cuando hacemos  la Exportación a APK, no cuando ejecutemos en emulador o el terminal directamente desde el Eclipse. Básicamente porque sería imposible usar el debug con el código ofuscado.

Sin embargo, no es todo tan bonito, los cambios de nombre tiene problemas

Si invocas clases o métodos de forma dinámica mediante el nombre, fallará, pues no se renombran.

- Los Activitys fallarán al no estar contemplados en el Manifiest	
- Las referencias de R pueden provocar distintos errores	
- Los ENUMs parece que también dar algún problema que otro.	


¿Solución? Añadir excepciones para que ProGuard no modifique ciertos ficheros. 


####ProGuard con Google Drive.
 
 En este caso esto se activa, con modificando las siguientes líneas del archivo **proguard-project.txt**, para añadir las excepciones necesarias para que todo siga funcionando correctamente. 
 

     -keep class * extends java.util.ListResourceBundle {
        protected Object[][] getContents();
    }

    -keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
        public static final *** NULL;
    }

    -keepnames @com.google.android.gms.common.annotation.KeepName class *
    -keepclassmembernames class * {
        @com.google.android.gms.common.annotation.KeepName *;
    }

    -keepnames class * implements android.os.Parcelable {
        public static final ** CREATOR;
    }
    
  
###Obtener certificado y registrar la Aplicación.

Proceso para certificar nuestra aplicación, y que cuando nuestra aplicación se conecte a Google Drive, reconozca la aplicación como legitima y sepa quien ha sido el autor.



-  Ir a la Google Console, https://console.developers.google.com/project
-  Crear un nuevo proyecto.

![](http://content.screencast.com/users/lopex-racing/folders/Jing/media/16cc96c6-5ded-414f-9a5e-e9a7d5556a66/2014-03-14_2335.png)



-  Asegurar que en APIs & auth, Drive API  esta en ON

![](http://content.screencast.com/users/lopex-racing/folders/Jing/media/0b43831d-648c-4732-8db0-a92d2e2a6659/2014-03-14_2337.png)


-  Entrar en Credentials, selecionar **"CREATE NEW CLIENT ID"**, y completar con la firma SHA1 (que enseño a continuación como se crea), y con el nombre exacto del **package**.

![](http://content.screencast.com/users/lopex-racing/folders/Jing/media/f6524038-144f-4ed9-8261-f9b757b2820f/2014-03-14_2340.png)

- Generar firma SHA1 de la aplicación. 

		keytool -exportcert -alias androiddebugkey -keystore <path_to_debug_or_production_keystore> -list -v

![](https://dl.dropboxusercontent.com/u/67403106/SHA1_fingerprint.png)

Decir que la aplicación **keytool**, se encuentra en el directorio donde esta instalado **Java**, en mi caso:  ``C:\Program Files (x86)\Java\jre7\bin``

Mi "path_to_debug_or_production_keystore", y por defecto para Eclipse es ``C:\Users\josemlp\.android\debug.keystore ``


Documentación [KeyTool](http://publib.boulder.ibm.com/tividd/td/TRM/SC23-4822-00/es_ES/HTML/user284.htm)

--------------

##Implementación Aplicación que accede a Google Drive.

Siguiendo la documentación de la [API de Drive para Android](https://developer.android.com/reference/com/google/android/gms/drive/package-summary.html


[Desarrollo con Android](https://developers.google.com/drive/android/get-started)

[Desarrollo con Ios](https://developers.google.com/drive/ios/quickstart)

[GitHub Android quickstart](https://github.com/googledrive/android-quickstart)

http://androiddev.orkitra.com/?p=100773
http://sbktech.blogspot.com.es/2014/01/inside-android-play-services-magic.html

https://developers.google.com/drive/android/create-file

