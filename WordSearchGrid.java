public class WordSearchGrid {
    private int rows; 
    private int columns;
    //currently have word array set to 8, should change so user can determine size
    private String[] words = new String[8];
    //constructor
    public WordSearchGrid(int rows, int columns) {
        this.rows = rows; 
        this.columns = columns;
    }
    //getters and setter
    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
    public int getColumns() {
        return columns;
    }
    public void setColumns(int columns) {
        this.columns = columns;
    }
    public String[] getWords() {
        return words;
    }
    public void setWords(String[] words) {
        this.words = words;
    }
}
