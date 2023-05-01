public class PilhaInt{
    private int top;
    private int tamanho; 
    private Integer[] pilha;
    

    PilhaInt(int tamanho){
        this.tamanho = tamanho;
        this.pilha = new Integer[tamanho];
        this.top = -1;
    }
 
    public void push(int n){
        this.top++;
        if(this.top < 0) this.top = 0; 
        
        if (this.top >= this.tamanho){
            this.top = this.tamanho -1;
            System.out.println("você ja atingiu o limite da sua fila, não pode adicionar mais valores ");
            return;
        }
        this.pilha[this.top] = n;
    }

    public int pop(){
        if (this.top == -1){
            System.out.println("Sua pilha ja esta vazia");
            return -1;
        }
        this.top--;
        return pilha[this.top+1];
    }
    public int length(){
        return this.top+1;
    }
    public int top(){
        if (this.top < 0){
            System.out.println("sua pilha esta vazia");
            return -1;
        }
        return pilha[this.top];
    }


      
} 