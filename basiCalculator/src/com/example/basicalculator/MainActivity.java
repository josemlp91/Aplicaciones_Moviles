package com.example.basicalculator;
import android.view.View.OnClickListener;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends Activity {

	TextView resultado ;
    String valorResultado;
    float numero1 ;
    float numero2 ;
    
    float calculo;
    operador eloperador;
    Button erase, porcien,pi, raiz,C,CE ,masmenos, cero ,uno, dos, tres , cuatro ,cinco , seis , siete , ocho, nueve ,  coma , igual, mas , menos, por, div;
    Boolean Ppulsa;
    Boolean signo;
    Boolean aiSigno;
    Boolean porci;
	
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        erase = (Button) findViewById(R.id.button1);
        cero = (Button) findViewById(R.id.button17);
        uno = (Button) findViewById(R.id.button13);
        dos = (Button) findViewById(R.id.button14);
        tres = (Button) findViewById(R.id.button15);
        cuatro = (Button) findViewById(R.id.button9);
        cinco = (Button) findViewById(R.id.button10);
        seis = (Button) findViewById(R.id.button11);
        siete = (Button) findViewById(R.id.button5);
        ocho = (Button) findViewById(R.id.button6);
        nueve = (Button) findViewById(R.id.button7);
        
        coma = (Button) findViewById(R.id.button18);
        igual = (Button) findViewById(R.id.button23);
        mas = (Button) findViewById(R.id.button19);
        menos = (Button) findViewById(R.id.button16);
        por = (Button) findViewById(R.id.button12);
        div = (Button) findViewById(R.id.button8);
        masmenos = (Button) findViewById(R.id.button4);
        raiz = (Button) findViewById(R.id.button20);
        porcien = (Button) findViewById(R.id.button21);
        pi = (Button) findViewById(R.id.button22);
        C = (Button) findViewById(R.id.button2);
        CE = (Button) findViewById(R.id.button3);
        
        resultado = (TextView) findViewById(R.id.textView1);
        Ppulsa=true;
        signo =true;
        aiSigno=false;
        porci=false;
       
        
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
        

        uno.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Ppulsa){ resultado.setText((String) uno.getText()); Ppulsa=false;  }
				else {
					valorResultado =(String) resultado.getText();
					resultado.setText((String) valorResultado + (String) uno.getText() );
				}
			}
        });
        
        dos.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Ppulsa){ resultado.setText((String) dos.getText()); Ppulsa=false;  }
				else {
					valorResultado =(String) resultado.getText();
					resultado.setText((String) valorResultado + (String) dos.getText() );
				}
			}
        });
        
        tres.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Ppulsa){ resultado.setText((String) tres.getText()); Ppulsa=false;  }
				else {
					valorResultado =(String) resultado.getText();
					resultado.setText((String) valorResultado + (String) tres.getText() );
				}
			}
        });
        
        cuatro.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Ppulsa){ resultado.setText((String) cuatro.getText()); Ppulsa=false;  }
				else {
					valorResultado =(String) resultado.getText();
					resultado.setText((String) valorResultado + (String) cuatro.getText() );
				}
			}
        });
        
        cinco.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Ppulsa){ resultado.setText((String) cinco.getText()); Ppulsa=false;  }
				else {
					valorResultado =(String) resultado.getText();
					resultado.setText((String) valorResultado + (String) cinco.getText() );
				}
			}
        });
        
        seis.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Ppulsa){ resultado.setText((String) seis.getText()); Ppulsa=false;  }
				else {
					valorResultado =(String) resultado.getText();
					resultado.setText((String) valorResultado + (String) seis.getText() );
				}
			}
        });
        
        siete.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Ppulsa){ resultado.setText((String) siete.getText()); Ppulsa=false;  }
				else {
					valorResultado =(String) resultado.getText();
					resultado.setText((String) valorResultado + (String) siete.getText() );
				}
			}
        });
        
        ocho.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Ppulsa){ resultado.setText((String) ocho.getText()); Ppulsa=false;  }
				else {
					valorResultado =(String) resultado.getText();
					resultado.setText((String) valorResultado + (String) ocho.getText() );
				}
			}
        });
        
        nueve.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Ppulsa){ resultado.setText((String) nueve.getText()); Ppulsa=false;  }
				else {
					valorResultado =(String) resultado.getText();
					resultado.setText((String) valorResultado + (String) nueve.getText() );
				}
			}
        });
        
        coma.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Ppulsa){ resultado.setText((String) coma.getText()); Ppulsa=false;  }
				else {
					valorResultado =(String) resultado.getText();
					resultado.setText((String) valorResultado + (String) coma.getText() );
				}
			}
        });
        
        erase.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Ppulsa){   }
				else {
					
					valorResultado =(String) resultado.getText();
						if (valorResultado.length()>1){
						resultado.setText((String) valorResultado.substring(0,valorResultado.length()-1) );
					}
					
					else {resultado.setText("0");Ppulsa=true;}
					
				}
				
				
			}
        });
        
        CE.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Ppulsa){ ; }
				else {
					resultado.setText("0"); Ppulsa=true; 
				}
				porci=false;
			}
        });
        
        C.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Ppulsa){ ; }
				else {
					resultado.setText("0"); Ppulsa=true; 
				}
				porci=false;
			}
        });
        
        pi.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Ppulsa){ resultado.setText("3.14159265359"); Ppulsa=false;  }
				else {
					resultado.setText("3.14159265359"); Ppulsa=false; 
				}
			}
        });
        
        masmenos.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				
					signo=!signo;
					
					
					valorResultado =(String) resultado.getText();
					if ((valorResultado.charAt(0)=='+') ||(valorResultado.charAt(0)=='-') ){valorResultado=valorResultado.substring(1,valorResultado.length()) ;}
					
					if (signo) resultado.setText("+" + (String) valorResultado );
					else resultado.setText("-" + (String) valorResultado );
				
				
			}
        });
        
        raiz.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				numero1=Float.valueOf(resultado.getText().toString());
				
				
				if (numero1<0){resultado.setText("E");}
				
				else {
					resultado.setText(Float.toString((float) Math.sqrt(numero1)));
					
				}
				porci=false;
			}
        });
        
        
        mas.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				if (Ppulsa){ ; }
				
				else {
					
					eloperador=operador.SUMA;
					numero1 = Float.valueOf(resultado.getText().toString());
					resultado.setText("0"); Ppulsa=true;
				
				}
				porci=false;
			}
        });
        
        
        menos.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				if (Ppulsa){ ; }
				
				else {
					
					eloperador=operador.RESTA;
					numero1 = Float.valueOf(resultado.getText().toString());
					resultado.setText("0"); Ppulsa=true;
				
				}
				porci=false;
			}
        });
        
        por.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				if (Ppulsa){ ; }
				
				else {
					
					eloperador=operador.MULT;
					numero1 = Float.valueOf(resultado.getText().toString());
					resultado.setText("0"); Ppulsa=true;
				
				}
				porci=true;
			}
        });
        
        div.setOnClickListener (new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				if (Ppulsa){ ; }
				
				else {
					
					eloperador=operador.DIV;
					numero1 = Float.valueOf(resultado.getText().toString());
					resultado.setText("0"); Ppulsa=true;
				
				}
				porci=false;
			}
        });
        
        porcien.setOnClickListener (new OnClickListener() {
 			@Override
 			public void onClick(View v) {
 				
 				if (porci){
 					
 					calculo = Float.valueOf(resultado.getText().toString());
 					calculo=calculo/100;
 				    resultado.setText(Float.toString((float) calculo));
 				}
 			}
         });
        
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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    
    
}
