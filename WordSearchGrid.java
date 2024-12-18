public class WordSearchGrid {
    private int rows; 
    private int columns;
    private String[] words;
    //constructor
    public WordSearchGrid(int rows, int columns, String[] words) {
        this.rows = rows; 
        this.columns = columns;
        this.words = words;
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
