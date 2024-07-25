
using System.ComponentModel.DataAnnotations;

namespace FP
{
    class Program
    {
        static void Main(string[] args)
        {
            //string str = Console.ReadLine();

            //Console.WriteLine(str);

            string str1 = "world";

            string str2 = @"c:\myfolder\test.txt";

            string str3 = $"Hello {str1}!";

            Console.WriteLine(str1);
            Console.WriteLine(str2);
            Console.WriteLine(str3);


            int i = 10;
            Console.WriteLine(i);

            //int j = int.Parse(Console.ReadLine());
            //short, long, uint
            //Console.WriteLine(j);

            float f = 10.5f;
            double d = 123.99;
            decimal dd = 345.90m;

            string[] days = new string[]
            {
                "Sunday",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
            };

            Console.WriteLine(days[0]);

            for(int z = 0; z < days.Length; z++)
            {
                Console.WriteLine(days[z]);
            }
        }
    }
}
