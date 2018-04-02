#include <stdio.h>
#include <stdlib.h>
struct Node* reverseLinkedList(struct Node* head);
void printLinkedList(struct Node* head);
struct Node* insertNode(struct Node* head, int data);

struct Node
{
    int data;
    struct Node* next;
};


int main(void){
    struct Node* head;
    struct Node* one;
    struct Node* two;
    struct Node* three;
    
    head = NULL;
    head = insertNode(head, 1); 
    head = insertNode(head, 2); 
    head = insertNode(head, 3); 
    head = insertNode(head, 4); 
    
    printLinkedList(head);
    head = reverseLinkedList(head);
    printLinkedList(head);
}
/**
 * Insert a new node at the end of the linked list
 *  @param head - a pointer to the head of the list
 *  @param data - the new data you want to insert
 *  @return head - the pointer to the updated linked list
 */
struct Node* insertNode(struct Node* head, int data){
    struct Node *temp = (struct Node*)malloc(sizeof(struct Node));
    temp->data = data;
    temp->next = NULL;
    if(head == NULL){
        head = temp;
    } else {
        struct Node* trav = head;
        while(trav->next != NULL){
            trav = trav->next;
        }
        trav->next =  temp;
    }
    return head;
}
/**
 * Print the linked list to the console.
 */
void printLinkedList(struct Node* head){
    struct Node *trav;
    trav = head;
    while(trav != NULL){
        printf("%d -> ",trav->data);
        trav = trav->next;
    }
    printf("NULL\n");
}

/**
 * Reverse the Linked List.
 * @param head - a pointer to the head of the linked list
 * @return head - a pointer to the new head of the reversed linked list
 */
struct Node* reverseLinkedList(struct Node* head){
    struct Node *trav, *prev, *next;
    trav = head;
    prev = NULL;
    while(trav != NULL){
        next = trav->next;
        trav->next = prev;
        prev = trav;
        trav = next;
    }
    head = prev;
    return head;
}
