#include <stdlib.h>
int main(void)
{
	

}
/*
 *gram to implement a stack that supports findMiddle() and deleteMiddle
   in O(1) time */
#include <stdio.h>
#include <stdlib.h>
 
/* A Doubly Linked List Node */
struct DLLNode
{
    struct DLLNode *prev;
    int data;
    struct DLLNode *next;
};
 
/* Representation of the stack data structure that supports findMiddle()
 *    in O(1) time.  The Stack is implemented using Doubly Linked List. It
 *       maintains pointer to head node, pointer to middle node and count of
 *          nodes */
struct myStack
{
    struct DLLNode *head;
    struct DLLNode *mid;
    int count;
};
 
/* Function to create the stack data structure */
struct myStack *createMyStack()
{
    struct myStack *ms =
               (struct myStack*) malloc(sizeof(struct myStack));
    ms->count = 0;
    return ms;
};
 
/* Function to push an element to the stack */
void push(struct myStack *ms, int new_data)
{
/* allocate DLLNode and put in data */
    struct DLLNode* new_node =
               (struct DLLNode*) malloc(sizeof(struct DLLNode));
    new_node->data  = new_data;
 
    /* Since we are adding at the begining,
 *       prev is always NULL */
    new_node->prev = NULL;
 
    /* link the old list off the new DLLNode */
    new_node->next = ms->head;
 
    /* Increment count of items in stack */
    ms->count += 1;
	if(ms->count == 1)
	{
		ms->mid = new_node;
	}
	else
	{
		ms->head->prev = new_node;
		//if count is odd
		if(ms->count & 1)
			ms->mid = ms->mid->prev;
	}
}
int pop()
{
}
