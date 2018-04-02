public class Royalty
{
   // a function that computes 35% of list price
   public class Royalty35Calculator  {
      double computeRoyalty(double listPrice) throws Exception {
         if(listPrice >= 0)
         {
            return (0.35*listPrice);
         }
         System.err.println("The list price cannot be negative");
         throw new Exception();
      }
   }

   // a function that computes 70% of (salePrice - deliveryCost), or 0 if sale price was 0; if the royalty amount is negative, returns 0.
   // a function that computes deliveryCost = $.12 * sizeInMb
   // minimum delivery cost: $0.01
   public class Royalty70Calculator {
      double computeRoyalty(double listPrice, double salePrice, long bytes) throws Exception {


         //validation    
         if(salePrice < 0 )
         {
            throw new Exception("The sale price cannot be negative.");
         }
         if(listPrice < 0)
         {
            throw new Exception("The list price cannot be negative.");
         }
         if(bytes <= 0)
         {
            throw new Exception("The number of bytes transmitted cannot be negative.");
         }

         if(salePrice == 0)
         {
            return 0;
         } 
         double dCost = computeDeliveryCost(bytes);
         double royalty = (0.70*(salePrice-dCost));
         if(royalty < 0)
            return 0;
         return royalty;


      }

      double computeDeliveryCost(long bytes) {
         double retValue = convertToMB(bytes) * 0.12;
         if(retValue < 0.01)
            return 0.01;
         return retValue;
      }
      double convertToMB(long bytes)
      {
         return (double)(((double)bytes)/((double)1000000));
      }
   }
}
