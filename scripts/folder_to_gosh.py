from os import listdir
import argparse
import re

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='Generate a (partly) GoSH file given a directory of jars')
    parser.add_argument('input_directory')
    parser.add_argument('-o', dest='output', help='File to output the GoSH file to, stdout if kept empty')

    args = parser.parse_args()

    output_text = ""
    

    # First attempt to list the directory
    try:
        files = filter(lambda x: x.endswith('.jar'), listdir(args.input_directory))
        pattern = re.compile('.*(-)?(?P<version>\d+.\d+.\d+).*')

        for jar in files:
            version = 0

            match = pattern.match(jar)
            if match:
                version = match.groupdict()['version']

            jar = re.sub('(-)?\d+.\d+.\d+', '', jar)

            output_text += '["identity"="{}" "version"="{}"]\n'.format(jar, version)


        if args.output:
            with open(args.output, 'w+') as f:
                f.write(output_text)
        else:
            print(output_text)
    except FileNotFoundError:
        print('input directory is not a valid directory!')
