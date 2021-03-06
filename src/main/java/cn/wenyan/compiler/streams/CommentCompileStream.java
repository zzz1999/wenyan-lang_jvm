package cn.wenyan.compiler.streams;

import cn.wenyan.compiler.CompileResult;
import cn.wenyan.compiler.WenYanCompilerImpl;
import cn.wenyan.compiler.WenYanLib;
import cn.wenyan.compiler.utils.Utils;

/**
 * 此为批注之编译流。亦可编译"注释"之术，曰: 经必有注也。
 * 批曰。「「文氣淋灕。字句切實」」。
 * 注曰。「「文言備矣」」。
 * 疏曰。「「居第一之位故稱初。以其陽爻故稱九」」。
 * 此术数亦在运行时忽略之。
 *
 * @author MagicLu
 * @see CompileStream
 */
public class CommentCompileStream extends CompileStream {


    public CommentCompileStream(WenYanCompilerImpl compiler) {
        super(compiler);
    }

    /**
     * 译之，若不成，则予下一流，反则为原文者乎
     * @param wenyan 上一流之返回者，亦为尚否编译者也
     * @return 编译之果
     */
    @Override
    public CompileResult compile(String[] wenyan) {
        if(Utils.matches(wenyan[0], WenYanLib.COMMENT())){
            Utils.inputWenyan(compiler,0);
            Utils.inputWenyan(compiler,1);
            return new CompileResult("/*"+Utils.getStringFrom(WenYanLib.COMMENT(),wenyan[1],WenYanLib.STRING_START(),WenYanLib.STRING_END())+"*/");
        }
        return new CompileResult(false,wenyan);
    }
}
