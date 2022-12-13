function OuterFunction() {
    var outerVariable = 100;
    function InnerFunction() {
        console.log(outerVariable);
    }
    return InnerFunction;
}
var innerFunc = OuterFunction();
innerFunc()
