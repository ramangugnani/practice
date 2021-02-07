package practice.javaprogramming.navi;

public class FileOpenMetadata {

    private String fileReference;

    private String fileName;

    private Integer blockIndex;

    private Integer blockLocation;

    private Integer userId;
    
    private FileOperation fileOperation;

    /**
     * @param fileReference
     * @param fileName
     * @param blockIndex
     * @param blockLocation
     */
    public FileOpenMetadata() {
        super();
    }

    /**
     * @return the fileReference
     */
    public final String getFileReference() {
        return fileReference;
    }

    /**
     * @param fileReference
     *                          the fileReference to set
     */
    public final void setFileReference(String fileReference) {
        this.fileReference = fileReference;
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
     * @return the blockIndex
     */
    public final Integer getBlockIndex() {
        return blockIndex;
    }

    /**
     * @param blockIndex
     *                       the blockIndex to set
     */
    public final void setBlockIndex(Integer blockIndex) {
        this.blockIndex = blockIndex;
    }

    /**
     * @return the blockLocation
     */
    public final Integer getBlockLocation() {
        return blockLocation;
    }

    /**
     * @param blockLocation
     *                          the blockLocation to set
     */
    public final void setBlockLocation(Integer blockLocation) {
        this.blockLocation = blockLocation;
    }

    /**
     * @return the userId
     */
    public final Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     *                   the userId to set
     */
    public final void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the fileOperation
     */
    public final FileOperation getFileOperation() {
        return fileOperation;
    }

    /**
     * @param fileOperation the fileOperation to set
     */
    public final void setFileOperation(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FileOpenMetadata [fileReference=" + fileReference + ", fileName=" + fileName + ", blockIndex="
                + blockIndex + ", blockLocation=" + blockLocation + ", userId=" + userId + ", fileOperation="
                + fileOperation + "]";
    }

}
