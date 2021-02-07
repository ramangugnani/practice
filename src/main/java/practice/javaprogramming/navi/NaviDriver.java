package practice.javaprogramming.navi;

/**
 * 
 * @author ramangugnani
 *
 *         Virtual File system
 *
 *         internally block size total block size we have number of free block
 *         occupied blocks
 * 
 *         we can assume meta data can be stored separately
 * 
 */
public class NaviDriver {
    public static void main(String[] args) throws OpernationNotAllowed {
        VirtualFileSystem vfs = new VirtualFileSystem();
        String refId = vfs.fOpen(123, "abc.txt", FileOperation.WRITE);
        vfs.fWrite(refId, 'a');
        vfs.fWrite(refId, 'b');
        vfs.fClose(refId);
        refId = vfs.fOpen(123, "abc.txt", FileOperation.READ);
        System.out.println(vfs.fRead(refId));
        System.out.println(vfs.fRead(refId));
        vfs.fClose(refId);
        
        
    }
}
