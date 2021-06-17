def writeFile(timesList, nameAlgorithm, sufix):
   fileLength=10
   f = open('ResultPython/'+nameAlgorithm+'-'+sufix+'.txt', 'w')

   for t in timesList:
       f.write('Execution time in nanoseconds of'+nameAlgorithm+' '+str(fileLength)+' : '+str(t*1000000000)+'\n')
       f.write('Execution time in microseconds of'+nameAlgorithm+' '+str(fileLength)+' : '+str(t*1000000)+'\n')
       fileLength *= 10

   f.close()
