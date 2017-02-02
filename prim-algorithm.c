#include <stdio.h>
main(int argc, char **argv)
{
 int i, k;
 int n, sum = 0;
 int W[10][10];
 int distance[10];
 int nearest[10];
 int F[10][10];
 int vnear, repeat, min;
 
 printf("Input n:");
 scanf("%d", &n);
 printf("Input W[%d][%d]:\n", n,n);
 for(i = 1; i <= n; i++){
  for(k = 1; k <= n; k++){
   scanf("%d", &W[i][k]);
  }
 }
 for(i = 0; i <= 10; i++){
  for(k = 0; k <= 10; k++){
   F[i][k] = 0;
  }
 }
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
 printf("\nF[%d][%d]\n", n, n);
 for(i = 1; i <= n; i++){
  for(k = 1; k <= n; k++){
   printf("%2d",F[i][k]);
  }
  printf("\n");
 }
 printf("\nW:\n");
 for(i = 1; i <= n; i++){
  for(k = 1; k <= n; k++){
   if(F[i][k] == 1){
    printf("%2d",W[i][k]);
    sum += W[i][k];
   }
   else
    printf(" 0");
  }
  printf("\n");
 }
 printf("\nsum = %d\n", sum);
 
}
