using System;
namespace Binomial
{
    class Program
    {
        static void Main(string[] args)
        {
            Program p = new Program();
            int n, k;
            int result;
            Console.WriteLine("Input n:");
            n = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Input k:");
            k = Convert.ToInt32(Console.ReadLine());
            result = p.bin(n, k);
            Console.WriteLine("Binomial Coefficient number is {0}", result);
            Console.ReadLine();
        }
        public int bin(int n, int k)
        {
            int i, j;
            int[,] B = new int[n + 1, k + 1];
            for (i = 0; i <= n; i++)
                for (j = 0; j <= minimum(i, k); j++)
                {
                    if (j == 0 || j == i)
                        B[i, j] = 1;
                    else
                        B[i, j] = B[i - 1, j - 1] + B[i - 1, j];
                }
            return B[n, k];
        }
        public int minimum(int i, int k)
        {
            if (i < k)
                return i;
            else
                return k;
        }
    }
}
