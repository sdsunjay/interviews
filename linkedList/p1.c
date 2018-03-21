#include <stdio.h>
#include <stdlib.h>

typedef struct Element{
    void *data;
    struct Element *next;
}Element;


/**
 * Add a new element the top from the stack.
 * @param **stack - a pointer to the head of the stack
 * @param **data - the data to be added to the stack
 * @return - whether or not the operation was successful
 */
int push(Element **stack, void *data){
    Element *elem = malloc(sizeof(Element));
    if(!elem)
        return 1;
    elem->data = data;
    elem->next = *stack;
    *stack = elem;
    return 0;
}

/**
 * Removes the top element from the stack.
 * @param **stack - a pointer to the head of the stack
 * @param **data - the data that has been removed from the stack
 * @return - whether or not the operation was successful
 */
int pop(Element **stack, void **data){
    Element *elem;
    elem = *stack;
    if( !(elem) )
        return 1;
    *data = elem->data;
    *stack = elem->next;
    free(elem);
    return 0;
}

/**
 * Initialize the Stack.
 */
int createStack(Element **stack){
    *stack = NULL;
    return 0;
}

/**
 * Iterate through the stack, deleting each Element.
 */
int deleteStack(Element **stack){
    Element *next;
    while(*stack){
        next = (*stack)->next;
        free(*stack);
        *stack = next;
    }
    return 0;
}

int main(void){
    return 0;
}
