def readFile(fileLength):

   f = open("Data/test"+str(fileLength)+".txt", "r")

   line = f.read()
   l = line.split(";")

   f.close()

   l = list(filter(None,l))
   l = list(map(int, l))
   return l

