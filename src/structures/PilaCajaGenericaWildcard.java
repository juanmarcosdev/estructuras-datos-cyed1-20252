package structures;

import java.lang.IndexOutOfBoundsException;
import java.lang.StackOverflowError;

public class PilaCajaGenericaWildcard {
  private Caja<?>[] arreglo;
  private int top;
  private int size;


  public PilaCajaGenericaWildcard(int n) {
    // Se crea arreglo de cajas con wildcard, con cast necesario
    this.arreglo = (Caja<?>[]) new Caja<?>[n];
    this.top = 0;
    this.size = n;
  }

  public void Push(Caja<?> caja) throws IndexOutOfBoundsException {
    if (this.top < this.size) {
      this.arreglo[top] = caja;
      this.top++;
    } else {
      throw new StackOverflowError();
    }
  }

  public Caja<?> Pop() throws IndexOutOfBoundsException {
    if (this.top > 0) {
      this.top--;
      return this.arreglo[top];
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  public Caja<?>[] getArreglo() {
    return arreglo;
  }

  public int getTop() {
    return top;
  }

  public int getSize() {
    return size;
  }

  public void setArreglo(Caja<?>[] arreglo) {
    this.arreglo = arreglo;
  }

  public void setTop(int top) {
    this.top = top;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
