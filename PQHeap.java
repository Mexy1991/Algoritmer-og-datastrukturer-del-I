/* * * * * * * * * * * * * * 
* Forfattere:
* Josephine Søgaard Andersen, josea18@student.sdu.dk
* Josias Kure, joulr18@student.sdu.dk 
* Kasper Jonassen, kajon18@student.sdu.dk 
* * * * * * * * * * * * * */
import java.util.*;
public class PQHeap implements PQ {

	int heapSize;
	Element[] listOfElements;

	//Constructor
	public PQHeap(int maxElms) {
		listOfElements = new Element[maxElms];		
    }

	// HeapSize angiver antallet af heap-elementer i arrayet, modsat array.length() der angiver arrayets længde
	public int heapSize(Element[] heapArray){ 
		heapSize = 0;
		for (int i = 0; i < heapArray.length; i++){
			if(heapArray != null){
			heapSize++;
			}		
		}
		return heapSize;
	}
	
	// Metoden extractMin() skal returnere det element i prioritetskøen, som har mindst prioritet.
	public Element extractMin(){
		if (heapSize < 1){
			System.out.println("Fejl");
		}
		Element min = listOfElements[1];
		listOfElements[1] = listOfElements[heapSize-1];
		//heapSize = heapSize;
		//minHeapify(listOfElements[1].getKey());
		minHeapify(1);
		return min;		
	}

	//Laver faktisk et heap
	public void minHeapify(int i){
		int left = left(i);
		int right = right(i);
		int smallest;

		if (left <= heapSize && listOfElements[left].getKey() < listOfElements[i].getKey()) {
			smallest = left;
			}
			else { 
			smallest = i;
			}

		if (right <= heapSize && listOfElements[right].getKey() < listOfElements[smallest].getKey()) {
			smallest = right;
		}

		if (smallest != i) {
		//Exchange A[i] with A[smallest]
			Element temp = listOfElements[i];
			listOfElements[i] = listOfElements[smallest];
			listOfElements[smallest] = temp;		
			minHeapify(smallest);
		}
	}

	/* Metoden insert(e) indsætter elementer til vores prioritets kø, listOfElements. 
	 * Disse elementer er givet vedhjælp af en scanner i main klassen.
	 */
	public void insert(Element e){
		heapSize = heapSize + 1;
		int i = heapSize;
		listOfElements[i] = e;
		
		while(i > 1 && listOfElements[parent(i)].getKey() < listOfElements[i].getKey()){
			Element temp = listOfElements[i];
			listOfElements[i] = listOfElements[parent(i)];
			listOfElements[parent(i)] = temp;		
			i = parent(i);
			//i = listOfElements[parent(i)].getKey()		
		}
		//minHeapify(i);
	}
	

/*
	
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

	*/

	/* Udregner parent, left og right */
	public int parent (int i){
		return i/2;
	}

	public int left (int i){
		return (2 * i);
	}

	public int right (int i){
		return (2*i) + 1;
	}
}


