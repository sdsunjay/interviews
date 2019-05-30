def solution(words, width):
    # result
    lines = []
    # current line we are adding words to
    current_line = []
    # width of the current line
    current_line_width = 0

    for word in words:
        # if the length is greater than the max width for the line
        if len(word) + current_line_width + len(current_line) > width:

            spaces = len(current_line) - 1 if len(current_line) -1 else 1

            for i in range(width - current_line_width):
                current_line[i % spaces] += " "
            lines.append("".join(current_line))
            current_line.clear()
            current_line_width = 0

        current_line.append(word)
        current_line_width += len(word)

    # special case to add spaces to the last line
    last_line = " ".join(current_line)
    last_line = last_line.strip()
    last_line = last_line + " " * (width - len(last_line))
    lines.append(last_line)

    return lines
