/*=============================================================================
 |   Assignment:  PEX1
 |       Author: Eric Kenes
 |      Section: T7
 |        Class:  CS483
 +-----------------------------------------------------------------------------
 |   Description:  This program was designed to create a working shell in C, with 4 commands
        inserted and the pre inserted functions from the execvp function on line 35.
 |
 |   Required Features Not Included:  Functionality 6, history and recall from the Cut Sheet
        is not included. I also failed to execute the ~ shorthand
 |
 |   Known Bugs:  I believe my parseSpace function fails to correctly tokenize the input
        resulting in the commands to not work correctly. I have error handling throughout
        both pex1.c and historyList.c to minimize errors and reduce segmentation faults.
 +-----------------------------------------------------------------------------
 |   Documentation Statement:  C2C Jason Tilley helped me understand how to implement parseSpace
        function with a focus on strtok, which allows me to accept the input until a tab or space
 *===========================================================================*/
#include <stdio.h>
#include <stdlib.h>
#include "historyList.h"
#include <sys/wait.h>
#include <string.h>
#include <unistd.h>
//Args function uses fork to create a child process and has error handling.
void Args(char** comd){
    pid_t  pid = fork();

    if (pid == -1){
        printf("\nFailed forking child");
        return;
    }
    else if(pid == 0){
        execvp(comd[0], comd);
        exit(0);
    }
    else{
        wait(NULL);
        return;
    }
}
//printDir prints the current working directory in the shell
void printDir(){
    char cwd[1024];
    getcwd(cwd, sizeof(cwd));
    printf("\nDir: %s", cwd);
}
//Uses strtok to tokenize the input and put it into the shell as a command.
void parseSpace(char* input, char** parsed){
    for(int i = 0; i < 100; i++){
        parsed[i] = strtok(input, "\t");
        if(parsed[i] == NULL)
            break;
        if(strlen(parsed[i]) == 0)
            i--;
    }
}
//Takes the input and inserts it into the linked list from the head
HistoryNodeType* takeInput(char* str, HistoryNodeType* listHeadPtr){
    HistoryNodeType* head;
    char buf[100];
    gets(buf);
    if (strlen(buf) != 0) {
        strcpy(str, buf);
        head = listInsertHead(listHeadPtr, str);

        return head;

    }else{return listHeadPtr;}

}
//Uses a while look to take the input and put it into the shell through the args function
int main() {
    char inputString[1000], *comd[100];
    HistoryNodeType* list = (HistoryNodeType*)malloc(sizeof(HistoryNodeType));
    while(strcmp(inputString, "exit") != 0){
        printDir();
//        if(takeInput(inputString, list)){
//            continue;
//        }
//        list = takeInput(inputString, list);
        takeInput(inputString, list);
        parseSpace(inputString, comd);
        Args(comd);

        // store inputString into LL


    }


    return 0;
}