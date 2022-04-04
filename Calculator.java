//Calculator with constructors

class CalculatorMain{
	public static void main(String [] args){
		Calculator calculator = new Calculator(new Display());
		calculator.fivePressed();
		calculator.sevenPressed();
		calculator.dividePressed();
		calculator.twoPressed();
		calculator.minusPressed();
		calculator.onePressed();
		calculator.fivePressed();
		calculator.equalPressed(); //13.5
	}
}

class Display{ //non ha costruttore -> default: Display(){}
	void display(String text) { //method: prende una stringa
		System.out.println(text); //e la stampa su output
	}
}

///////////////////////////////////////////////////////////

public class Calculator{
	final Display display; //oggetto di tipo Display, di nome display
	String value = ""; //con una stringa posso concatenare più cifre
	double result; //di default  = 0.0, quindi non serve inizializzarla
	char operator = ' ';
	
	public Calculator(Display display){//costruttore di calc. che ha come arg. 
		this.display = display; //un ogg di tipo Display
	}
	
	void zeroPressed(){ 
		value += "0";
		display.display(value); //richiamo il metodo display per stampare 0
	}
	void onePressed(){ 
		value += "1";		
		display.display(value); 		
	}
	void twoPressed(){
		value += "2";
		display.display(value); 
	}
	void threePressed(){ 
		value += "3";
		display.display(value); 
	}
	void fourPressed(){ 
		value += "4";
		display.display(value);
	}
	void fivePressed(){ 
		value += "5";
		display.display(value);
	}
	void sixPressed(){ 
		value += "6";
		display.display(value); 
	}
	void sevenPressed(){ 
		value += "7";
		display.display(value); 
	}
	void eightPressed(){ 
		value += "8";
		display.display(value); 
	}
	void ninePressed(){ 
		value += "9";
		display.display(value); 
	}
	void commaPressed(){
		value += ".";
		display.display(value);
	}
	
	void plusPressed(){
		operations();
		display.display(String.valueOf(result));
		operator = '+';
		//ora devo azzerare la stringa
		String tmp = value.replaceAll(value, "");
		value = tmp;
	}	
	void minusPressed(){
		operations();
		display.display(String.valueOf(result));
		operator = '-';
		String tmp = value.replaceAll(value, "");
		value = tmp;
	}	
	void xPressed(){
		operations();
		display.display(String.valueOf(result));
		operator = '*';
		String tmp = value.replaceAll(value, "");
		value = tmp;
	}	
	void dividePressed(){
		operations();
		display.display(String.valueOf(result));
		operator = '/';
		String tmp = value.replaceAll(value, "");
		value = tmp;
	}	
	void equalPressed(){
		operations();
		display.display(String.valueOf(result));		
	}
	void cancPressed(){
		String tmp = value.replaceAll(value, "");
		value = tmp;
		result = 0.0;
		display.display(String.valueOf(result));
	}
	void signPressed(){
		double tmp = Double.parseDouble(value);
		result = 0 - tmp;
		display.display(String.valueOf(result));
	}	
	
	void operations(){ //calcola result
		double tmp = Double.parseDouble(value);
		switch(operator){
			case '+':
			result = result + tmp;
			break;
			case '-':
			result = result - tmp;
			break;
			case '*':
			result = result * tmp;
			break;
			case '/':
			result = result / tmp;
			break;
			case ' ':
			result = tmp;			
		}		
	}
}

/*COSA DEVO FARE?
[SOLVED]
devo creare dei metodi nella class Calculator per leggere i tasti
che digito dalla tastiera (0,1,2,...,+,-,*....) e stamparli su un
oggetto di tipo Display, e poi devo creare dei metodi per eseguire
le operazioni della calcolatrice. per testare queste classi ho bisogno
di un'altra classe "CalculatorTest" che contenga un metodo main.
nel main devo creare un oggetto d tipo calc. per poter usare i metodi.

[SOLVED] metodi operazioni:
NON devo stampare il simbolo, ma devo prendere il valore pecedente
memorizzarlo "somewhere" e poi fare l'operazione con il valore
successivo -> mi servono 2 variabili double per registrare i valori

[SOLVED] 
devo computare l'operazione quando inserisco il secondo valore,
altrimenti se ho più operazioni concatenate mi fa il risultato
solo dell'ultima!

[NOT SOLVED]
dopo l'uguale fare altre operazioni???

*/



	