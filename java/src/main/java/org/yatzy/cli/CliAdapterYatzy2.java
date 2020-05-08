package org.yatzy.cli;

import org.yatzy.vendor2.Yatzy2;

public class CliAdapterYatzy2 {
    public static void main(String[] args){
        CliAdapter.main(args, new Yatzy2(0,0,0,0,0));
    }
}
