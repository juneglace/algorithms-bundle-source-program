import java.util.Scanner;
public class prim_algorithm {
 public static void main(String[] args) {
  int n, sum = 0;
  Scanner scan = new Scanner(System.in);
  System.out.println("Input n:");
  n = scan.nextInt();
  System.out.println("Input W["+n+"]["+n+"]:");
  int[][] W = new int[n+1][n+1];
  for(int i = 1; i <= n; i++)
   for(int k = 1; k <= n; k++)
    W[i][k] = scan.nextInt();
  
  Prim prim = new Prim(n, W);
  prim.Process();
  
  System.out.println("\nF["+n+"]["+n+"]");
  for(int i = 1; i <= n; i++){
   for(int k = 1; k <= n ;k++)
    System.out.print(prim.getF()[i][k]+" ");
   System.out.println();
  }
  
  System.out.println("\ne:");
  for(int i = 1; i <= n; i++){
   for(int k = 1; k <= n ;k++){
    if(prim.getF()[i][k] == 1){
     System.out.print(W[i][k]+" ");
     sum += W[i][k];
    }
    else
     System.out.print("0 ");
   }
   System.out.println();
  }
  System.out.println("\nsum ="+sum);
 }
}
class Prim {
 private int[] distance;
 private int[] nearest;
 private int[][] F;
 private int[][] W;
 private int i, vnear;
 private int n, repeat, min;
 public Prim(int n, int[][] W) {
  this.W = W;
  this.n = n;
 }
 public int[][] getF() {
  return F;
 }
 public void Process() {
  nearest = new int[n+1];
  distance = new int[n+1];
  F = new int[n+1][n+1];
  
  for(i = 2; i <= n; i++){
   nearest[i] = 1;
   distance[i] = W[1][i];
  }
  
  for(repeat = 0; repeat < n; repeat++){
   min = 100;
   for(i = 2; i <= n; i++){
    if(0 <= distance[i] && distance[i] < min){
     min = distance[i];
     vnear = i;
    }
     
   }
   F[vnear][nearest[vnear]] = 1;
   distance[vnear] = -1;
   for(i = 2; i <= n; i++){
    if(W[i][vnear] < distance[i]){
     distance[i] = W[i][vnear];
     nearest[i] = vnear;
    }
   }
  }
  
  
 }
 
}
