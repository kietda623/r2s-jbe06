#include <stdio.h>
#include <math.h>

void inputArr(int a[], int *n) {
    do {
        printf("Enter number of elements from 1 to 100: ");
        scanf("%d", n);
    } while (*n < 1 || *n > 100);

    for (int i = 0; i < *n; i++) {
        printf("Enter element %d: ", i + 1);
        scanf("%d", &a[i]);
    }
}

void outputArr(int a[], int n) {
    printf("Array: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", a[i]);
    }
}

void descendingOrder(int a[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (a[i] < a[j]) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }
}

int oddElement(int a[], int n) {
    for (int i = 0; i < n; i++) {
        if (a[i] % 2 == 0)
            return 0;
    }
    return 1;
}

void searchValue(int a[], int n) {
    int x, count = 0;
    printf("Enter value to search: ");
    scanf("%d", &x);

    for (int i = 0; i < n; i++) {
        if (a[i] == x)
            count++;
    }

    printf("Value %d appears %d time(s)\n", x, count);
}

int isPrime(int x) {
    if (x < 2)
        return 0;
    for (int i = 2; i <= sqrt(x); i++) {
        if (x % i == 0)
            return 0;
    }
    return 1;
}

void displayPrimeElements(int a[], int n) {
    printf("Prime elements: ");
    for (int i = 0; i < n; i++) {
        if (isPrime(a[i]))
            printf("%d ", a[i]);
    }
    printf("\n");
}

int quitProgram() {
    int confirm;
    printf("Are you sure? Enter 1 to exit: ");
    scanf("%d", &confirm);
    return confirm == 1;
}

int main() {
    int a[100];
    int n = 0;
    int choice;

    do {
        printf("1. Input array\n");
        printf("2. Output array\n");
        printf("3. Sort descending\n");
        printf("4. Check all odd\n");
        printf("5. Search value\n");
        printf("6. Display prime numbers\n");
        printf("7. Quit\n");
        printf("Choose: ");
        scanf("%d", &choice);

        switch (choice) {
        case 1:
            inputArr(a, &n);
            break;
        case 2:
            outputArr(a, n);
            break;
        case 3:
            descendingOrder(a, n);
            outputArr(a, n);
            break;
        case 4:
            if (oddElement(a, n))
                printf("All elements are odd\n");
            else
                printf("Not all elements are odd\n");
            break;
        case 5:
            searchValue(a, n);
            break;
        case 6:
            displayPrimeElements(a, n);
            break;
        case 7:
            if (quitProgram())
                return 0;
            break;
        default:
            printf("Invalid choice!\n");
        }
    } while (1);
}
