import scala.io.Source

object MarkerFinder{
    val scrdir = "/home/migusb/projects/adventofcode-2022/day-06/input.txt"

    def main(args: Array[String]) = {
        val word = readlines(scrdir)
        val recordedindex = getpacket(word, 4)

        println(recordedindex.slice(0,1))
    }

    def ifrepeat(piece: String) = {
        piece.toSet.toList.sorted == piece.toList.sorted        
    }


    def getpacket(word: String, packetlength: Int) = {
        val recordedindex = 
            for (index <- Range(0, word.toList.length-packetlength) if ifrepeat(word.slice(index, index+packetlength)))
            yield index + packetlength
        
        recordedindex 
    }


    def readlines(scrdir: String) = {
        val word = Source.fromFile(scrdir).mkString
        word
   }       
}