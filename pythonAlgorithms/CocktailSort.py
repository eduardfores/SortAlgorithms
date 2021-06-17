from readFile import readFile
from writeFile import writeFile
import time

class CocktailSort:

    def cocktailSort(self, a):
        n = len(a)
        swapped = True
        start = 0
        end = n-1
        while (swapped == True):

            swapped = False

            for i in range(start, end):
                if (a[i] > a[i + 1]):
                    a[i], a[i + 1] = a[i + 1], a[i]
                    swapped = True

            if (swapped == False):
                break

            swapped = False

            end = end-1

            for i in range(end-1, start-1, -1):
                if (a[i] > a[i + 1]):
                    a[i], a[i + 1] = a[i + 1], a[i]
                    swapped = True

            start = start + 1

    def execution(self):
      fileLength=10
      l = list()

      for i in range(0, 3):
         for j in range(0, 5):
            arr = readFile(fileLength)
            print(fileLength)

            start = time.time()
		
            self.cocktailSort(arr)

            stop = time.time()
            
            l.append(stop - start)
            
            fileLength *= 10

         writeFile(l, 'CockTailSort', 'Run'+str(i+1))
         del l[:]
         fileLength = 10

cs = CocktailSort()

cs.execution()
