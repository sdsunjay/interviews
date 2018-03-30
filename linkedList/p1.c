#include <stdio.h>
#include <stdlib.h>

typedef struct Element{
    int *data;
    struct Element *next;
}Element;


/**
 * Add a new element to the top from the stack.
 * @param **stack - a pointer to the head of the stack
 * @param **data - the data to be added to the stack
 * @return - whether or not the operation was successful
 */
int push(Element **stack, int *data){
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
int pop(Element **stack, int **data){
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
    int i;
    Element **top = (Element**) malloc(sizeof(Element*));
    createStack(top);
    int *data = (int*) malloc(sizeof(int));
    for(i=0; i<5; i++){
        *data = i+1;
        if(push(top, data)==1){
            printf("Error!");
        }
        else {
            printf("Value added: %d\n", *data);
        }
    }
    for(i=0; i<5; i++){
        if(pop(top, &data)==1){
            printf("Error!");
        }
        else {
            printf("Value deleted from stack: %d\n", *data);
        }
    }
    deleteStack(top);
    return 0;
}
