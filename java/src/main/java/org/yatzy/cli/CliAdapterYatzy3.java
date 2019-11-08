package org.yatzy.cli;

import org.yatzy.vendor3.Yatzy3;

public class CliAdapterYatzy3 {
    public static void main(String[] args){
        CliAdapter.main(args, new Yatzy3());
    }
}