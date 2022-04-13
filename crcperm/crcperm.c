#include <stdio.h>
#include <stdlib.h>

unsigned short crc16(char *ptr, int count)
{
   int  crc;
   char i;
   crc = 0;
   while (--count >= 0)
   {
      crc = crc ^ (int) *ptr++ << 8;
      i = 8;
      do
      {
         if (crc & 0x8000)
            crc = crc << 1 ^ 0x1021;
         else
            crc = crc << 1;
      } while(--i);
   }
   return (crc);
}

int main(void)
{
   char text[4];
   char letter1, letter2, letter3;
   unsigned short checksum = 0;
   FILE *fp;

   fp = fopen("out.txt", "w+");

   /* Loop through ASCII characters A-Z and a-z */
   for (letter1 = 65; letter1 < 123; letter1++)
   {
      if (letter1 > 90 && letter1 < 97)
         letter1 += 6;

      text[0] = letter1;

      for (letter2 = 65; letter2 < 123; letter2++)
      {
         if (letter2 > 90 && letter2 < 97)
            letter2 += 6;

         text[1] = letter2;

         for (letter3 = 65; letter3 < 123; letter3++)
         {
            if (letter3 > 90 && letter3 < 97)
               letter3 += 6;

            text[2] = letter3;
            text[3] = '\0';

            checksum = crc16(text, 3);
            fprintf(fp, "String: %s; CRC: %04X\n", text, checksum);
         }
      }
   }

   fclose(fp);

   return 0;
}
