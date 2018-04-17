#include <stdio.h>                                                                 
#include <stdlib.h>                                                                
#include <unistd.h>                                                                
#include <math.h>
struct Node {
   int value;
   struct Node* left;
   struct Node* right;
};

int checkTree(struct Node* root)
{
   return checkTree1(root,root->value,root->value);
}


int checkTree1(struct Node* root, int min,int max)
{
   //return value
   int returnValue=1;
   int leftValue;
   leftValue=1;
   int rightValue;
   rightValue=1;

   if(root->left)
   {
      if(root->left->value>=root->value)
      {
         returnValue=0;
      }
      else
      {
     
         returnValue=checkChildrenLess(root,min);
         leftValue=checkTree1(root->left,root->value,max);
      
      }
      //printf("root has left\n");
   }
   if(root->right)
   {
      if(root->right->value<=root->value && root->right->value<min)
      {
         returnValue=0;

      }
      else
      {
         returnValue=checkChildrenMore(root,max);
         rightValue=checkTree1(root->right,min,root->value);
      }
      //printf("root has right\n");
   }

   return (returnValue && rightValue && leftValue);
}
int checkChildrenLess(struct Node* root,int min)
{
   //printf("min is: %d\n",min);
   if(root->left)
   {
      if(root->left->value>=min)
      {
       
         //printf("NOT ok \n");
         return 0;
      }
   }

   if(root->right)
   {
      if(root->right->value>=min)
      {
         //printf("NOT ok\n");
         return 0;
      }
   }
   //printf("ok less\n");
   return 1;
}
int checkChildrenMore(struct Node* root,int max)
{

   if(root->left)
   {
      if(root->left->value<=max)
         return 0;
   }

   if(root->right)
   {
      if(root->right->value>=max)
         return 0;

   }
  // printf("ok more\n");
   return 1;
}
void printTree(struct Node* root)
{
   printf("Tree:\n");
   printf("\t\t\t\t%d\n\n",root->value);
   printf("\t\t%d",root->left->value);
   printf("\t\t\t%d\n\n",root->right->value);
   printf("\t\t\t%d\n\n",root->left->right->value);
}
int main (void)
{

   struct Node* s;                                                           
   int height;                                                                     
   s=(struct Node*)malloc(sizeof(struct Node)*1);                      
   s->value=5;                                                                     
   s->left=(struct Node*)malloc(sizeof(struct Node)*1);                      
   s->right=(struct Node*)malloc(sizeof(struct Node)*1);                      
   s->right->value=9;
   s->left->value=2;
   s->left->right=(struct Node*)malloc(sizeof(struct Node)*1);                      
   s->left->right->value=7;
   printTree(s);
   printf("Ok? (1 - yes | 0 - no): %d\n",checkTree(s));                                               

   return 0;
}
