#BasiCalculator
-------------
## 

##Introdución.

Aplicación básica, con interfaz de una calculadora **estándar**, con todas las funcionalidades básicas tal como la calculadora de Windows.

Permite realizar operaciones aritméticas simples.

No he cuidado demasiado el diseño gráfico dado, que mi intención es ir tomando contacto con la programación Android.

##Entorno utilizado.

He probado los distintos entornos de programación que existen para Android, tanto en el sistema operativo **Ubuntu 13.10** como en **Windows 7**.


- **NetBeans con plugins Android**, dado que es el entorno con el que más familiarizado estoy, dado que lo he utilizado para desarrollar ya algunas aplicaciones tanto  de escritorio en Java, como aplicaciones web.
	- Para instalar los plugins podemos seguir este [tutorial](http://tarjuccino.com/tutoriales/desarrollo-movil/configuracion-del-android-sdk-en-netbeans-7/)

Me ha gustado su rapidez, facilidad para completar código y formatearlo.
Otra característica interesante es la posibilidad para conectarlo con sistemas de control de versiones como **git**.

El problema que he encontrado, y que ha hecho que elija otro entorno ha sido, que no representa de forma gráfica los layout en XML.


- Android Studio, me a gustado bastante, y me ha parecido bastante flexible, pero me ha costado un poco familiarizarme con el, y he visto que no se comporta tan rápido como me gustaría ni en **Windows** ni en **Ubuntu**

Se puede descargar desde el [enlace](http://developer.android.com/sdk/installing/studio.html)

- Eclipse con SDK Android, es una versión de Eclipse con características, especificas para desarrollar para **Android**. 

Definitivamente esta opción es la que más me ha atraído, por varias razones.

Es el entorno después de Netbeans que mejor conozco y que más cómodo me encuentro, se ejecuta rápido y parece no ser demasiado pesado.

Me muestra como van quedando los layout de forma gráfica.

Se puede descargar en el [link](http://developer.android.com/sdk/index.html)


##Construcción.

###Layout

La aplicación cuenta únicamente con una pantalla, por tanto únicamente tenemos que crear un documento **xml** para usarlo como  layout.

 Para la tarea de crear layout podemos apoyarnos en la aplicación [DroidDraw](http://www.droiddraw.org/) que nos permite, incorporar elementos de una forma gráfica e intuitiva, y configurar esto elementos a nuestro gusto.

Obteniendo el código XML directamente.

En esta tarea lo más importante es tener identificado el campo `` android:id="@+id/<elID>"`` de cada elemento, puesto que este campo nos permitirá identificar el elementos cuando programemos la aplicación.

Por eso es recomendable ir asignando ID, que podamos recordar fácilmente.

Por defecto el primer layout de la aplicación es ``layout.activity_main`` al cual le incorporo los siguientes elementos:

- ``TextView``, que es donde se van mostrando el número que escribimos y el resultado de las operaciones aritmética.
Los métodos más interesantes que de este elemento son:

~~~

	setText(<string>) y string=getText()

~~~

- ``Button``, 23 botones, que nos permiten marcar los números y las operaciones.

Lo más interesante de este evento es crear "el manejador del evento click"

~~~

	boton.setOnClickListener (new OnClickListener() {
	
		public void onClick(View v) { //lo que queremos que haga con el click }
	
	});

~~~

### MainActivity

Esta código principal de la aplicación ``MainActivity``, donde se ejecuta el ``loop``.

Lo primero que hace es crear la ventana, y colocar elementos tal cual le indica el ``layout.activity_main``.

~~~

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
~~~

Lo primero que debemos hacer es crear una variables que representen los elementos que tenemos (Button y TextViwer)

Para eso debemos importar:

~~~

	import android.widget.Button;
	import android.widget.TextView;

~~~

Y creamos las variables, ``TextView resultado `` y `` Button boton`` y relacionarlas con su elemento del layout.

~~~

	boton = (Button) findViewById(R.id.<idBoton>);
	resultado = (TextView) findViewById(R.id.<idtextview>);
 
~~~

Ya podemos ir programando cada uno de los botones, utilizando el manejador de eventos, por ejemplo para un boton seria.

~~~

        cero.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Ppulsa){ resultado.setText((String) cero.getText()); Ppulsa=false;  }
				else {
					valorResultado =(String) resultado.getText();
					resultado.setText((String) valorResultado + (String) cero.getText() );
				}
			}
        });
 
~~~


Para manejar los operadores creamos un enum tal como este:

```java
	public enum operador {
	SUMA,RESTA,MULT,DIV,PORCIEN
}

```

Así en cuando pulsamos la tecla igual, se ejecuta este código:



	igual.setOnClickListener (new OnClickListener() {
				@Override
				public void onClick(View v) {
					numero2 = Float.valueOf(resultado.getText().toString());
					
					 switch (eloperador) {
					 
			            case SUMA: 
			            			calculo=numero1+numero2;
			            			resultado.setText(Float.toString(calculo));
			            			break;
			            case RESTA:
					            	calculo=numero1-numero2;
			            			resultado.setText(Float.toString(calculo));
			            			break;
			            case MULT: 
					            	calculo=numero1*numero2;
			            			resultado.setText(Float.toString(calculo));
			            			break;
			            case DIV:  
					            	calculo=numero1/numero2;
			            			resultado.setText(Float.toString(calculo));
			            			break;
			            			
			            
			           
			            default: 
			                     break;
			        }
					
					
				}
	        });

~~~

La aplicación queda de la siguiente manera:
##Captura 

![](https://github.com/josemlp91/Aplicaciones_Moviles/blob/master/basiCalculator/capturas/basiCal.png?raw=true)

##GitHib

Enlace repositorio: [BasiCalculator](https://github.com/josemlp91/Aplicaciones_Moviles/tree/master/basiCalculator)