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

	/* Constructoren returnerer en ny, tom prioritetskø, hvor argumentet maxElms angiver det
	*  maksimale antal elementer, der skal være plads til i køen
	*/
	public PQHeap(int maxElms) {
		listOfElements = new Element[maxElms];		
    }
	 
	/* Metoden extractMin() skal returnere det element i prioritetskøen, som har mindst prioritet */
	public Element extractMin(){
		if (heapSize < 1){
			System.out.println("error: heap underflow");
		}
		Element min = listOfElements[1];
		listOfElements[1] = listOfElements[heapSize];
		heapSize = heapSize-1;
		minHeapify(1);
		return min;		
	}

	/* Laver min-heapstrukturen */
	public void minHeapify(int i){
		int left = left(i);
		int right = right(i);
		int smallest;

		/* Hvis venstre barn er mindre eller lig heapstørrelsen
		 * og dets prioritet er mindre end i's prioritet, sættest venstre som mindre. 
		 * Hvis ikke, sættes i som mindre.
		 */
		if (left <= heapSize && listOfElements[left].getKey() < listOfElements[i].getKey()) {
			smallest = left;
			}
		else { 
			smallest = i;
			}

		/* Hvis højre barn er mindre eller lig heapstørrelsen
		 * og dets prioritet er mindre end i's prioritet, sættest højre som mindre.
		 */
		if (right <= heapSize && listOfElements[right].getKey() < listOfElements[smallest].getKey()) {
			smallest = right;
		}

		/* Her byttes rundt på listOfElements[i] og listOfElements[smallest] 
		*  ved hjælp af det midlertidige Element temp
		*/
		if (smallest != i) {
			Element temp = listOfElements[i];
			listOfElements[i] = listOfElements[smallest];
			listOfElements[smallest] = temp;		
			minHeapify(smallest);
		}
	}

	/* Metoden insert (Element e) indsætter elementetet e i prioritetskøen listOfElements. 
	*  HeapSize angiver antallet af heap-elementer i arrayet, modsat array.length(), der angiver arrayets længde
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
		}
	}

	/* Her udregnes parent, left og right */
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