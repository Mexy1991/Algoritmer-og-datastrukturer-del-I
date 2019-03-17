/* * * * * * * * * * * * * * 
* Forfattere:
* Josephine Søgaard Andersen, josea18@student.sdu.dk
* Josias Kure, joulr18@student.sdu.dk 
* Kasper Jonassen, kajon18@student.sdu.dk 
* * * * * * * * * * * * * */
import java.util.*;
public class PQHeap implements PQ {

	int heapSize;
	//int maxElms;
	Element[] listOfElements;

	public PQHeap(int maxElms) {
		//PQHeap pqheap = new PQHeap(maxElms);
		//this.maxElms = i;
		listOfElements = new Element[maxElms];
    }




	public int heapSize(Element[] heapArray){ 
	//Først skal vi have størrelsen på heapet
	heapSize = 0;
	for (int i = 0; i < heapArray.length; i++){
		if(heapArray != null){
		heapSize++;
		}		
	}
	return heapSize;
	}
	       


		 
	public Element extractMin(){
	// Metoden extractMin() skal returnere det element i prioritetsken, som har mindst prioritet.
	int i = 0;
	//while(i<heapSize)
	return listOfElements[i];
	}



	public void insert(Element e){
	// Metoden insert(e) skal indstte elementet e i prioritetskøen.
	int i = 0;
        for (int j = 0; j < listOfElements.length; j++) {
            if(listOfElements[j] == null){
                listOfElements[j] = e;
                break;
            }else{
                i++;
            }
		}
	}

	
}
