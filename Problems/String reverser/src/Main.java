StringReverser reverser = new StringReverser(){
    @Override
    public String reverse(String str){

        return new StringBuilder(str).reverse().toString();
        }
        };/* create an instance of an anonymous class here,
                             do not forget ; on the end */