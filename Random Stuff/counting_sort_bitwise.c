#include <stdlib.h>
#include <stdio.h>
// Assuming no duplicates
void countingSort(const int* array, const int length) {
    int min = array[0],max = array[0];
    for (int i = 0; i < length; ++i) {
        if(array[i] > max) max = array[i];
        if(array[i] < min) min = array[i];
    }
    const int range = (max - min + 1) / 8 + (((max - min + 1) % 8) ? 1 : 0);
    unsigned char* count = (unsigned char*) calloc(sizeof(unsigned char), range);
    for (int i = 0; i < length; ++i) {
        const int offset = array[i] - min;
        count[offset / 8] |= (1 << offset % 8);
    }
    for (int i = 0; i < range; ++i) {
        for (int j = 0; j < 8; ++j) {
            if(count[i] & (1 << j)) {
                printf("%d ",i * 8 + j + 1);
            }
        }
    }
    free(count);
}
int main() {
    int a[] = {9,8,4,7,1,2,3,6};
    int len = 8;
    countingSort(a,len);
}