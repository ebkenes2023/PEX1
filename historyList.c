#include "historyList.h"
#include <stdio.h>
#include <stdlib.h>

HistoryNodeType* listInsertTail(HistoryNodeType* list, char* value){
    HistoryNodeType* newNode = (HistoryNodeType*)malloc(sizeof (HistoryNodeType));

    newNode->data = value;
    newNode->next = NULL;
    if(list == NULL){
        return newNode;
    }
    else{
        HistoryNodeType* node = list;
        while(node->next!=NULL){
            node = node->next;
        }
        node->next = newNode;
        return list;
    }
}

HistoryNodeType* listInsertHead(HistoryNodeType* list, char* value){
    HistoryNodeType* newNode = (HistoryNodeType*)malloc(sizeof (HistoryNodeType));
    newNode->data = value;

    if(list->data == NULL){
        newNode->next = NULL;
        list = newNode;
        return list;
    } else {
        newNode->next = list;
        return newNode;
    }
}


HistoryNodeType* listInsertN(HistoryNodeType* list, char* value , int location) {
    HistoryNodeType *newNode = (HistoryNodeType *) malloc(sizeof(HistoryNodeType));
    newNode->data = value;
    if(location == 1){
        newNode->next = list;
        return newNode;
    }
    else{
        HistoryNodeType* temp = list;
        for (int i = 1; i < location - 1; ++i) {
            temp = temp->next;
        }
        newNode->next = temp->next;
        temp->next = newNode;
        return list;
    }
}


HistoryNodeType* listRemove(HistoryNodeType* list, char* value){
    HistoryNodeType* node = list;
    HistoryNodeType* prev = list;
    if(list->data == value){
        list = list->next;
        free(prev);
        return list;
    }
    else{
        while(node->next!=NULL){
            prev = node;
            node = node->next;
            if(node->data == value){
                prev->next=node->next;
                free(node);
                return list;
            }

        }
    }
}


HistoryNodeType* listRemoveN(HistoryNodeType* list, int location){
    if(list == NULL){
        return NULL;
    }
    HistoryNodeType* temp = list;

    if(location == 1){
        list = temp->next;
        free(temp);
        return list;
    }
    for(int i = 1; temp != NULL && i < location - 1; i++){
        temp = temp->next;
    }
    if(temp->next == NULL){
        return list;
    }
    else if(temp->next->next == NULL){
        temp->next = NULL;
        return list;
    }
    else {
        HistoryNodeType *next = temp->next->next;
        free(temp->next);
        temp->next = next;
        return list;
    }
}

void listPrint(HistoryNodeType* list){
    HistoryNodeType* temp = list;
    while(temp != NULL){
        printf(" %s\n", (temp->data));
        temp = temp->next;
    }
}


void listPrintN(HistoryNodeType* list, int value){
    HistoryNodeType* temp = list;
    for(int i = 1; i < value; i++) {
        temp = temp->next;
    }
    printf("%s\n", (temp->data));
}


char* listGet(HistoryNodeType* list, int location){
    int current = 1;
    HistoryNodeType* currentPtr = (HistoryNodeType*) malloc(sizeof(HistoryNodeType));
    currentPtr = list;
    while (current < location) {
        current++;
        currentPtr = currentPtr->next;
    }
    return currentPtr->data;
}


void listDestroy(HistoryNodeType* list){
    HistoryNodeType* delete;
    HistoryNodeType* store;
    delete = list;
    while(delete != NULL){
        store = delete->next;
        free(delete);
        delete = store;
    }
}


