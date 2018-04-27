public class Calculator extends pabloBaseVisitor<Integer> {

    @Override
    public Integer visitExpression(pabloParser.ExpressionContext ctx) {
        return this.visitBaseExpression(ctx.baseExpression());
    }

    @Override
    public Integer visitBaseExpression(pabloParser.BaseExpressionContext ctx) {
        return this.visitAddSubtract(ctx.addSubtract());
    }

    @Override
    public Integer visitAddSubtract(pabloParser.AddSubtractContext ctx) {
        Integer number = this.visitMultiplyDivide(ctx.multiplyDivide());
        if (ctx.addSubtract() == null) {
            return number;
        }
        Integer number2 = this.visitAddSubtract(ctx.addSubtract());
        if (ctx.Plus() == null) {
            return number2 - number;
        }
        return number + number2;

    }

    @Override
    public Integer visitMultiplyDivide(pabloParser.MultiplyDivideContext ctx) {
        Integer number = this.visitPrimaryExpression(ctx.primaryExpression());
        if (ctx.multiplyDivide() == null) {
            return number;
        }
        Integer number2 = this.visitMultiplyDivide(ctx.multiplyDivide());
        if (ctx.Multiply() == null) {
            return number2/number;
        }
        return number*number2;
    }

    @Override
    public Integer visitPrimaryExpression(pabloParser.PrimaryExpressionContext ctx) {
        if (ctx.number() == null) {
            return this.visitBaseExpression(ctx.baseExpression());
        }
        return this.visitNumber(ctx.number());
    }

    @Override
    public Integer visitNumber(pabloParser.NumberContext ctx) {
        return Integer.parseInt(ctx.Number().getText());
    }
}
