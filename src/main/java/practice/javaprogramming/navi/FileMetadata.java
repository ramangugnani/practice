package practice.javaprogramming.navi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileMetadata {
    
    private String fileName;

    private List<Integer> memoryBlocks = new ArrayList<Integer>();

    private Integer fileSize = 0;

    private Set<Integer> readAllowedUser = new HashSet<>();

    private Set<Integer> writeAllowedUser = new HashSet<>();

    /**
     * 
     */
    public FileMetadata() {
        super();
    }

    /**
     * @return the fileName
     */
    public final String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     *                     the fileName to set
     */
    public final void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the memoryBlocks
     */
    public final List<Integer> getMemoryBlocks() {
        return memoryBlocks;
    }

    /**
     * @param memoryBlocks
     *                         the memoryBlocks to set
     */
    public final void setMemoryBlocks(List<Integer> memoryBlocks) {
        this.memoryBlocks = memoryBlocks;
    }

    /**
     * @return the fileSize
     */
    public final Integer getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize
     *                     the fileSize to set
     */
    public final void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * @return the readAllowedUser
     */
    public final Set<Integer> getReadAllowedUser() {
        return readAllowedUser;
    }

    /**
     * @param readAllowedUser
     *                            the readAllowedUser to set
     */
    public final void setReadAllowedUser(Set<Integer> readAllowedUser) {
        this.readAllowedUser = readAllowedUser;
    }

    /**
     * @return the writeAllowedUser
     */
    public final Set<Integer> getWriteAllowedUser() {
        return writeAllowedUser;
    }

    /**
     * @param writeAllowedUser
     *                             the writeAllowedUser to set
     */
    public final void setWriteAllowedUser(Set<Integer> writeAllowedUser) {
        this.writeAllowedUser = writeAllowedUser;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FileMetadata [fileName=" + fileName + ", memoryBlocks=" + memoryBlocks + ", fileSize=" + fileSize
                + ", readAllowedUser=" + readAllowedUser + ", writeAllowedUser=" + writeAllowedUser + "]";
    }

}
